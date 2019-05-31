package com.consistent.facilities.models;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.consistent.facility.interfaces.Constants;
import com.consistent.facility.interfaces.XML;
import com.consistent.facility.portal.Portal;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.impl.JournalArticleImpl;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

public class Facility extends Portal implements XML, Constants{
	
	private static final Log log = LogFactoryUtil.getLog(Facility.class);
	
	private String guid;
	private String name;
	private String title;
	private String language;
	private String keyword;
	private String description;
	private String type;
	private List<String> medialinks;
	
	public List<String> getMedialinks() {
		return medialinks;
	}

	public void setMedialinks(List<String> medialinks) {
		this.medialinks = medialinks;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static Log getLog() {
		return log;
	}

	public Facility(String guid, String name, String title, String language, String keyword, String description,
			String order, String channel, String type) {
		super();
		this.guid = guid;
		this.name = name;
		this.title = title;
		this.language = language;
		this.keyword = keyword;
		this.description = description;
		this.type = type;
	}
	
	public Facility(){
		this.guid = "";
		this.name = "";
		this.title = "";
		this.language = "";
		this.keyword = "";
		this.description = "";
		this.type = "";
	}
	
	/**
	 * @author bernardohernandez
	 * @category facility
	 * @return Devuelve el xml en String
	 */

	@Override
	public String getMapping() throws XMLStreamException, IOException {
		
		StringWriter stringWriter = new StringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xMLStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
		
			xMLStreamWriter.writeStartElement("content");
					xMLStreamWriter.writeStartElement("guid");
						xMLStreamWriter.writeCharacters(guid);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("name");
						xMLStreamWriter.writeCharacters(name);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("title");
						xMLStreamWriter.writeCharacters(title);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("language");
						xMLStreamWriter.writeCharacters(language);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("keyword");
						xMLStreamWriter.writeCharacters(keyword);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("description");
						xMLStreamWriter.writeDTD(description);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("order");
						xMLStreamWriter.writeCharacters(ORDER);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("channel");
						xMLStreamWriter.writeCharacters(CHANNEL);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("type");
						xMLStreamWriter.writeCharacters(type);
					xMLStreamWriter.writeEndElement();
					//mediaLink section
					/*mediaLink section*/
			         JSONArray ArrayMediaLinks = JSONFactoryUtil.createJSONArray();
			         List<String> MeliaLinkList = getMedialinks();
						for (String mediaLinkItem : MeliaLinkList) {
							JSONObject myObject;
							try {
								
								myObject = JSONFactoryUtil.createJSONObject(mediaLinkItem);
								ArrayMediaLinks.put(myObject);
							} catch (JSONException e) {
								log.error("Error converter json"+e);
							}
							
						}
						xMLStreamWriter.writeStartElement("medialinks");		   
				         xMLStreamWriter.writeStartElement("medialink");
				         
						   xMLStreamWriter.writeStartElement("keyword");
						   xMLStreamWriter.writeEndElement();
						         for (int i = 0; i < ArrayMediaLinks.length(); i++) {
										JSONObject jsonobject = ArrayMediaLinks.getJSONObject(i);
									    String link = jsonobject.getString("link");
									    String type_image = jsonobject.getString("type_image");
										xMLStreamWriter.writeStartElement("multimedia");
							            xMLStreamWriter.writeAttribute("type",type_image);
								        xMLStreamWriter.writeStartElement("url");
								        xMLStreamWriter.writeCharacters(link);
								        xMLStreamWriter.writeEndElement();
							            xMLStreamWriter.writeEndElement();
									}
						         xMLStreamWriter.writeStartElement("thumbnail");
						         xMLStreamWriter.writeEndElement();
						         xMLStreamWriter.writeStartElement("type");
						         xMLStreamWriter.writeEndElement();
					      xMLStreamWriter.writeEndElement();
			         xMLStreamWriter.writeEndElement();
			          //mediaLink section
			xMLStreamWriter.writeEndElement();
		
		xMLStreamWriter.flush();
		xMLStreamWriter.close();
		String result = stringWriter.getBuffer().toString();
		stringWriter.close(); 
		
		return result;
	}
	
	/**
	 * @author bernardohernandez
	 * @category facility
	 * @return Devuelve la lista de todos los facilities
	 */
	private HashSet<String> getFacilitiesAll(){
		HashSet<String> articlesRecovery = new HashSet<>();
		int count = 0;
		
		try {
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "JournalArticle",PortalClassLoaderUtil.getClassLoader());
			if(com.consistent.facility.constants.Constants.KEYWORD==null){
				dynamicQuery.add(RestrictionsFactoryUtil.eq("folderId", getFolderIdFacility()));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", com.consistent.facility.constants.Constants.GROUP_ID));
				HashSet<JournalArticleImpl> articles = new HashSet<>(JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery));
				for (JournalArticleImpl journalArticleImpl : articles) {
					if(!journalArticleImpl.isInTrash()){
						if(JournalArticleLocalServiceUtil.isLatestVersion(com.consistent.facility.constants.Constants.GROUP_ID, journalArticleImpl.getArticleId(),journalArticleImpl.getVersion())){
							articlesRecovery.add(parseFacility(journalArticleImpl));
							count++;
						}
					}
				}
				
			}else{
				
				dynamicQuery.add(RestrictionsFactoryUtil.eq("DDMStructureKey", getFacilityIdFilter(com.consistent.facility.constants.Constants.KEYWORD)));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("folderId", getFolderIdFacility()));
				dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", com.consistent.facility.constants.Constants.GROUP_ID));
				HashSet<JournalArticleImpl> articles = new HashSet<>(JournalArticleResourceLocalServiceUtil.dynamicQuery(dynamicQuery));
				for (JournalArticleImpl journalArticleImpl : articles) {
					if(!journalArticleImpl.isInTrash()){
						if(JournalArticleLocalServiceUtil.isLatestVersion(com.consistent.facility.constants.Constants.GROUP_ID, journalArticleImpl.getArticleId(),journalArticleImpl.getVersion())){
							articlesRecovery.add(parseFacility(journalArticleImpl));
							count++;
						}
					}
				}
			}
			log.info("Filtrados: "+count);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("getFacilities: "+e);
		}
		return articlesRecovery;
	}
	/**
	 * @author bernardohernandez
	 * @param article
	 * @return Devuelve el mapeo del xml en String
	 * @category facility
	 * @throws DocumentException
	 * @throws XMLStreamException
	 * @throws IOException
	 * @throws PortalException
	 */
	private String parseFacility(JournalArticle article) throws DocumentException, XMLStreamException, IOException, PortalException{
		Facility facility = new Facility();
		String locale = com.consistent.facility.constants.Constants.getLanguaje();
		facility.guid = article.getArticleId();
		facility.title = article.getTitle(locale);
		Document document = null;
		document = SAXReaderUtil.read(article.getContentByLocale(locale));
		facility.name = document.valueOf("//dynamic-element[@name='nameFacility']/dynamic-content/text()");
		facility.keyword = document.valueOf("//dynamic-element[@name='keywordFacility']/dynamic-content/text()");
		facility.description = document.valueOf("//dynamic-element[@name='descriptionFacility']/dynamic-content/text()");
		facility.language = com.consistent.facility.constants.Constants.LANGUAGE;
		facility.type = article.getDDMStructure().getName(locale);
		//Medialinks
		List<Node> mediaNodes = document.selectNodes("//dynamic-element[@name='mediaLinksFacility']/dynamic-element");
		List<String> mediaArray = new ArrayList<String>();
		for (Node mediaNode : mediaNodes) {
			String pie = mediaNode.valueOf("dynamic-element[@name='footerMediaLinkFacility']/dynamic-content/text()");
			String link = mediaNode.valueOf("dynamic-content/text()");
			String type_image = mediaNode.valueOf("dynamic-element[@name='typeFacility']/dynamic-content/text()");
			if(!link.trim().equals("")){
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("link", link);
				object.put("pie", pie);
				object.put("type_image", type_image);
				mediaArray.add(object.toJSONString());
			}
		}
		
		facility.medialinks = sanitizeArray(mediaArray);
		return facility.getMapping();
	}
	
	private List<String> sanitizeArray(List<String> arraySan){
	    	if(arraySan.size()>0){
		    	while(arraySan.size()<1){
					JSONObject object=JSONFactoryUtil.createJSONObject();
					arraySan.add(object.toJSONString());				
				}
	    	}
	    	
	    	return arraySan;    	
	    }
	/**
	 * @author bernardohernandez
	 * @param keyword
	 * @return Devuleve el identificador del keyword en Long
	 * @throws PortalException 
	 */
	private String getFacilityIdFilter(String keyword) throws PortalException{
		DDMStructure results;
		switch (keyword) {
		case RESTAUTANT:
			log.info(RESTAUTANT);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.RESTAURANTE_ID);
			return results.getStructureKey();
		case MEETING_ROOM:
			log.info(MEETING_ROOM);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.MEETING_ROOM_ID);
			return results.getStructureKey();
		case BAR:
			log.info(BAR);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.BAR_ID);
			return results.getStructureKey(); 
		case FIESTA_KIDS:
			log.info(FIESTA_KIDS);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.FIESTA_KIDS_CLUB_ID);
			return results.getStructureKey(); 
		case SPA:
			log.info(SPA);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.SPA_ID);
			return results.getStructureKey();
		case FACILITY:
			log.info(FACILITY);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.FACILITY_ID);
			return results.getStructureKey();
		case GYM:
			log.info(GYM);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.GYM_ID);
			return results.getStructureKey();
		default:
			log.info("Esta opcion no esta disponible");
			return new String("0");
		}
		
	}
	 /**
	  * @author bernardohernandez
	  * @return Devuelve el String del contenedor principal en String
	  * @throws XMLStreamException, IOException
	  * @category facility
	  */
	@Override
	public String getContent() throws XMLStreamException, IOException {
		// TODO Auto-generated method stub
		StringWriter stringWriter = new StringWriter();
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xMLStreamWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
		xMLStreamWriter.writeStartDocument();
			xMLStreamWriter.writeStartElement("contents");
				for (String facilities : getFacilitiesAll()) {
					xMLStreamWriter.writeCharacters(facilities);
				}
			xMLStreamWriter.writeEndElement();
		xMLStreamWriter.writeEndDocument();
		xMLStreamWriter.flush();
		xMLStreamWriter.close();
		String result = stringWriter.getBuffer().toString();
		result = result.replace("&lt;", "<").replace("&gt;", ">");
		stringWriter.close(); 
		return result;
	}
}
