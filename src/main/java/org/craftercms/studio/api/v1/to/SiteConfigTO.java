/*******************************************************************************
 * Crafter Studio Web-content authoring solution
 *     Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.craftercms.studio.api.v1.to;


import java.io.Serializable;
import java.util.Date;

/**
 * This class stores Site Configuration
 *
 * @author hyanghee
 * @autho Dejan Brkic
 *
 */
public class SiteConfigTO implements Serializable {

	/**
	 *
	 */
	protected static final long serialVersionUID = 3411780412457597813L;

    /**
     * WEM project name
     */
    protected String wemProject;

    /**
     * site name
     */
    protected String siteName = null;

	/**
	 * site display name
	 */
	protected String name = null;

	/**
	 * default content type
	 */
	//protected String _defaultContentType = null;

	/** URL to download content assets */
	//protected String _assetUrl = null;

	/**
	 * site model configuration mapping that is used to generate model data
	 */
	//protected Map<QName, ModelConfigTO> _modelConfig;

	/** a map of namespaces and types **/
	//protected Map<String, QName> _namespaceToTypeMap = null;

	/** the last updated date of site configuration **/
	protected Date lastUpdated = null;

    /** web project configuration if the site is dm-based **/
    protected RepositoryConfigTO repositoryConfig = null;

	/** default search configuration for all content type **/
	//protected SearchConfigTO _defaultSearchConfig = null;

	/** default timezone **/
	protected String timezone = null;

    /**
     * @return the WEM project
     */
    public String getWemProject() {
        return wemProject;
    }

    /**
     * @param wemProject
     *            the WEM project to set
     */
    public void setWemProject(String wemProject) {
        this.wemProject = wemProject;
    }

    /**
     * @return the name
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * @param siteName
     *            the name to set
     */
	/*
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }*/

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the modelConfig
	 */
	/*
	public Map<QName, ModelConfigTO> getModelConfig() {
		return _modelConfig;
	}*/

	/**
	 * @param modelConfig
	 *            the modelConfig to set
	 */
	/*
	public void setModelConfig(Map<QName, ModelConfigTO> modelConfig) {
		this._modelConfig = modelConfig;
	}*/

	/**
	 * @param defaultContentType
	 *            the defaultContentType to set
	 */
	/*
	public void setDefaultContentType(String defaultContentType) {
		this._defaultContentType = defaultContentType;
	}*/

	/**
	 * @return the defaultContentType
	 */
	/*
	public String getDefaultContentType() {
		return _defaultContentType;
	}*/

	/**
	 * @param lastUpdated
	 *            the lastUpdated to set
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * @return the lastUpdated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

    /**
     * @return the repositoryConfig
     */
    public RepositoryConfigTO getRepositoryConfig() {
        return repositoryConfig;
    }

    /**
     * @param repositoryConfig the webProjectConfig to set
     */
    public void setRepositoryConfig(RepositoryConfigTO repositoryConfig) {
        this.repositoryConfig = repositoryConfig;
    }

	/**
	 * @param assetUrl the assetUrl to set
	 */
	/*
	public void setAssetUrl(String assetUrl) {
		this._assetUrl = assetUrl;
	}*/

	/**
	 * @return the assetUrl
	 */
	/*
	public String getAssetUrl() {
		return _assetUrl;
	}*/

	/**
	 * get the content asset download URL template
	 *
	 * @param site
	 * @param id
	 * @param contentType
	 * @return the content asset download URL
	 *//*
	public String getAssetUrlTemplate(String site, Long id, String contentType) {
		if (!StringUtils.isEmpty(_assetUrl)) {
			return _assetUrl.replaceFirst(StudioConstants.PATTERN_SITE, site)
					.replaceFirst(StudioConstants.PATTERN_ID, String.valueOf(id))
					.replaceFirst(StudioConstants.PATTERN_CONTENT_TYPE, contentType);
		}
		return null;
	}*/

	/**
	 * @param defaultSearchConfig the defaultSearchConfig to set
	 *//*
	public void setDefaultSearchConfig(SearchConfigTO defaultSearchConfig) {
		this._defaultSearchConfig = defaultSearchConfig;
	}*/

	/**
	 * @return the defaultSearchConfig
	 */
	/*
	public SearchConfigTO getDefaultSearchConfig() {
		return _defaultSearchConfig;
	}*/

	/**
	 * @param namespaceToTypeMap the namespaceToTypeMap to set
	 */
	/*
	public void setNamespaceToTypeMap(Map<String, QName> namespaceToTypeMap) {
		this._namespaceToTypeMap = namespaceToTypeMap;
	}*/

	/**
	 * @return the namespaceToTypeMap
	 */
	/*
	public Map<String, QName> getNamespaceToTypeMap() {
		return _namespaceToTypeMap;
	}*/

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
}
