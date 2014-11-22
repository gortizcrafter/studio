/*******************************************************************************
 * Crafter Studio Web-content authoring solution
 *     Copyright (C) 2007-2013 Crafter Software Corporation.
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
package org.craftercms.cstudio.impl.service.content;

import java.net.*;
import java.io.*;
import java.io.InputStream;
import org.dom4j.io.SAXReader;
import java.lang.reflect.Method;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import org.apache.commons.io.IOUtils;

import org.craftercms.cstudio.api.log.*;
import org.craftercms.cstudio.api.to.ContentItemTO;
import org.craftercms.cstudio.api.repository.ContentRepository;

/**
 * Content Services that other services may use
 * @author russdanner
 */
public class ContentServiceImpl  {

    protected static final String MSG_ERROR_IO_CLOSE_FAILED = "err_io_closed_failed";

    private static final Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class);

    /**
     * @return true if site has content object at path
     */
    public boolean contentExists(String site, String path) {
        return this._contentRepository.contentExists(site, path);
    }

    /**
     * get document from wcm content
     *
     * @param path
     * @return document
     * @throws ServiceException
     */
    public InputStream getContent(String path) {
       return this._contentRepository.getContent(path);
    }

    /**
     * get document from wcm content
     * @param path
     * @return document
     * @throws ServiceException
     */
    public String getContentAsString(String path) throws Exception {
        return IOUtils.toString(_contentRepository.getContent(path));
    }

    /**
     * get document from wcm content
     *
     * @param path
     * @return document
     * @throws ServiceException
     */
    public Document getContentAsDocument(String path)
    throws DocumentException {
        Document retDocument = null;
        InputStream is = this.getContent(path);

        if(is != null) {
            try {
                SAXReader saxReader = new SAXReader();          
                retDocument = saxReader.read(is);
            } 
            finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } 
                catch (IOException err) {
                    logger.error(MSG_ERROR_IO_CLOSE_FAILED, err, path);
                }
            }       
        }

        return retDocument;
    }

    /**
     * get a content item for a given site and path
     * @param site - the site
     * @param path = the path of content to get
     */
    public ContentItemTO getContentItem(String site, String path) {
        ContentItemTO item = null;

        if(this.contentExists(site, path)) { 
            // don't keep this check it's too slow
            // the idea heare is that repo does not know enough to get an item,
            // this requires either a different servivice/subsystem or a combination of them
            item = new ContentItemTO();
        }

        return item;
    }

    private ContentRepository _contentRepository;
    public ContentRepository getContentRepository() { return _contentRepository; }
    public void setContentRepository(ContentRepository contentRepository) { this._contentRepository = contentRepository; }
}
