<#import "/templates/system/common/cstudio-support.ftl" as studio />

<html lang="en">
	<head>
  		<meta charset="UTF-8">
 		<title>Crafter Activiti Form Example</title>
 		<script src="//code.jquery.com/jquery-3.1.0.min.js" integrity="sha256-cCueBR6CsyA4/9szpPfrX3s49M9vUU5BgtiJj06wt/s=" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
		<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
	</head>

	<body>
		<button id='startProcessBtn'>Start Process</button>
		<table id="tasks" class="display" cellspacing="0" width="100%">
	        <thead>
	            <tr> <th>ID</th> <th>Task Name</th> <th>Assignee</th> <th>Created</th> </tr>
	        </thead>
	    </table>
	    <div id="form"></div>

		<script>
			function initTaskList() {
				var table = $('#tasks').DataTable({ 
					ajax: {
					url: '/api/1/services/get-tasks.json', 
					dataSrc: function ( json ) {
						var dataArray = [];
						for ( var i=0, ien=json.data.length ; i<ien ; i++ ) {
							var entry = json.data[i];
							dataArray[i] = [entry.id, entry.name, (entry.assignee.firstName + " " + entry.assignee.lastName), entry.created]
						}
						return dataArray;
    				}}
				});

				$('#tasks tbody').on( 'click', 'tr', function () {
        			if ( $(this).hasClass('selected') ) {
            		$(this).removeClass('selected');
        		}
        		else {
            		table.$('tr.selected').removeClass('selected');
           		 	$(this).addClass('selected');
           		 	renderForm(table.row( this ).data()[0]);
        		} });

        		setInterval( function () { table.ajax.reload(); }, 1000 );
			};

			function updateTaskList() {
			}



			function renderForm(taskId) {
				var formEl = $("#form");
				formEl.html("");

				var formContent = document.createElement("div");

				$.get( "/api/1/services/get-form-def.json?taskId="+taskId, function( data ) {
					var fields = data.fields[0].fields[1];
					var len = fields.length;

					for ( var i=0 ; i<len ; i++ ) {
						var field = fields[i];

						if(field.type == "text") {
							var fieldContainerEl = document.createElement("div");
							var labelEl = document.createElement("label");
							labelEl.innerHTML = field.name;
							labelEl.for = field.id;
							labelEl.id = field.id+"Label";
							var inputEl = document.createElement("input");
							inputEl.id = field.id;
							formEl.append(fieldContainerEl);
							fieldContainerEl.appendChild(labelEl);
							fieldContainerEl.appendChild(inputEl);	 				
						}
						else if(field.type = "multi-line-text") {
							var fieldContainerEl = document.createElement("div");
							var labelEl = document.createElement("label");
							labelEl.innerHTML = field.name;
							labelEl.for = field.id;
							labelEl.id = field.id+"Label";
							var inputEl = document.createElement("textarea");
							inputEl.id = field.id;
							formEl.append(fieldContainerEl);
							fieldContainerEl.appendChild(labelEl);
							fieldContainerEl.appendChild(inputEl);	 						
						}
					}

					var fieldContainerEl = document.createElement("div");
					var inputEl = document.createElement("button");
					inputEl.id = "formSubmit";
					inputEl.taskId = taskId;
					inputEl.innerHTML = "Complete";
					formEl.append(fieldContainerEl);
					fieldContainerEl.appendChild(inputEl);
					$("#formSubmit").taskId = taskId;	

					$("#formSubmit").click(function() {
					    var taskId = document.getElementById("formSubmit").taskId;
						$.get( "/api/1/services/submit-form.json?taskId="+taskId, function( data ) {
  							updateTaskList();
  							formEl.html("");
  						});
					});
  				});
			}

			$( "#startProcessBtn" ).click(function() {
  				$.get( "/api/1/services/start-process.json", function( data ) {
  					alert("process started");
  					updateTaskList();
  				});
			});

			$(document).ready(function() {
				initTaskList();    
			});
		</script>

	</body>
</html>
