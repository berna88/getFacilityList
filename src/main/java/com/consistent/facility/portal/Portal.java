package com.consistent.facility.portal;

import java.util.List;

import com.consistent.facility.constans.Constants;
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
	
	protected Long getFolderId(String hotelCode){
		
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("name", hotelCode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", ""));
			List<JournalFolderImpl> list = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = list.get(0).getFolderId();
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getFolderId: "+e);
		}
		log.info("FolderId: "+folderId);
		return folderId;
	}
	
	protected Long getFolderIdFacility(){
		Long folderId = null;
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalFolderImpl.class,"Folder",PortalClassLoaderUtil.getClassLoader());
			dynamicQuery.add(RestrictionsFactoryUtil.eq("name", NAME_FOLDER_FACILITY));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", ""));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("parentFolderId", ""));
			List<JournalFolderImpl> list = JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery);
			folderId = list.get(0).getFolderId();
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getFolderIdFacility"+e);
		}
		log.info("FolderId: "+folderId);
		return folderId;
	}
}
