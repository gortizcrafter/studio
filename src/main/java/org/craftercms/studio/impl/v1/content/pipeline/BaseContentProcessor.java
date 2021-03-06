/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.impl.v1.content.pipeline;

import org.apache.commons.lang.StringUtils;
import org.craftercms.studio.api.v1.content.pipeline.ContentProcessor;
import org.craftercms.studio.api.v1.content.pipeline.PipelineContent;
import org.craftercms.studio.api.v1.exception.ContentProcessException;
import org.craftercms.studio.api.v1.log.Logger;
import org.craftercms.studio.api.v1.log.LoggerFactory;
import org.craftercms.studio.api.v1.to.ResultTO;

/**
 * A base class of content processor
 *
 * @author hyanghee
 *
 */
public class BaseContentProcessor implements ContentProcessor {

	private static final Logger logger = LoggerFactory.getLogger(BaseContentProcessor.class);

	public static final String NAME = "BaseContentProcessor";

	/** the default process name if not set **/
	protected String _name;

	/**
	 * default constructor
	 */
	public BaseContentProcessor() {
		this._name = NAME;
	}

	/**
	 * constructor that sets the process name
	 *
	 * @param name
	 */
	public BaseContentProcessor(String name) {
		this._name = name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this._name = name;
	}

	public String getName() {
		return _name;
	}

	public boolean isProcessable(PipelineContent content) {
		return true;
	}

	public void process(PipelineContent content, ResultTO result) throws ContentProcessException {
		logger.debug("Processing " + content.getId() + " through " + _name);
	}

	/**
	 * check if the mandatory value provided is not empty
	 *
	 * @param key
	 * @param value
	 * @throws ContentProcessorException
	 */
	public void checkForMandatoryParam(String key, String value) throws ContentProcessException {
		if (StringUtils.isEmpty(value)) {
			throw new ContentProcessException(key + " is a mandatory parameter.");
		}
	}
}
