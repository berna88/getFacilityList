package com.consistent.facility.portal;

import java.util.List;

import com.consistent.facility.interfaces.Constants;
import com.liferay.journal.model.impl.JournalFolderImpl;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
/**
 * 
 * @author bernardohernandez
 * @version 1.0
 * @category Portal
 * 
 */
public abstract class Portal implements Constants{
	 
	private static final Log log = LogFactoryUtil.getLog(Portal.class);
	
	/**
	 * @author bernardohernandez
	 * @param hotelCode
	 * @return Devuelve el identificador de la carpeta hotel
	 */
	
	protected Long getFolderId(String hotelCode){
		log.info("<-- getFolderId -->");
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("name", hotelCode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", new Long(com.consistent.facility.constants.Constants.GROUP_ID)));
			List<JournalFolderImpl> list = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = list.get(0).getFolderId();
			
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			log.error("Codigo de hotel no encontrado");
			log.error("getFolderId: "+e);
		}
		log.info("FolderId por codigo: "+folderId);
		return folderId;
	}
	
	/**
	 * @author bernardohernandez
	 * @return Devuelve el identificador de la carpeta facility del hotelcode en Long
	 */
	
	protected Long getFolderIdFacility(){
		log.info("<-- getFolderIdFacility -->");
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("name", NAME_FOLDER_FACILITY));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId",com.consistent.facility.constants.Constants.GROUP_ID));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("parentFolderId", getFolderId(com.consistent.facility.constants.Constants.HOTEL_CODE)));
			List<JournalFolderImpl> list = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = list.get(0).getFolderId();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getFolderIdFacility"+e);
		}
		log.info("FolderId de facility: "+folderId);
		return folderId;
	}
		
}
