package com.consistent.facility.application;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.xml.stream.XMLStreamException;

import org.osgi.service.component.annotations.Component;

import com.consistent.facilities.models.Facility;
import com.consistent.facility.constants.Constants;
import com.consistent.facility.interfaces.Autentification;
import com.consistent.facility.interfaces.XML;
import com.consistent.facility.segurity.AutentificationImp;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author liferay
 * @category Portal
 * @version 1.0
 */
@ApplicationPath("/service/posadas")
@Component(immediate = true, service = Application.class)
public class GetFacilityListApplication extends Application{
	
	private static final Log log = LogFactoryUtil.getLog(GetFacilityListApplication.class);
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	/**
	 * @author bernardohernandez
	 * @return Devuelve el XML en tipo String
	 * @param siteId, hotelcode, language, channel, keyword
	 * @throws IOException 
	 * @throws XMLStreamException 
	 * @throws PortalException 
	 */
	@GET
	@Path("/getFacilityList")
	@Produces(MediaType.APPLICATION_XML)
	public String getFacilityList(
		@Context HttpServletRequest request, 
		@Context HttpHeaders headers,
		@QueryParam("siteId") long siteId,
		@QueryParam("language") String language,
		@QueryParam("hotelcode") String hotelcode,
		@QueryParam("channel") String channel,
		@QueryParam("keyword") String keyword) throws XMLStreamException, IOException, PortalException {
		log.info("<-- getFacilityList -->");
		//Asignando Variables
		Constants.GROUP_ID = siteId;
		Constants.LANGUAGE = language;
		Constants.HOTEL_CODE = hotelcode;
		Constants.KEYWORD = keyword;
		//Obtiene el metodo que contiene toda la información
		Autentification autentification = new AutentificationImp(request, headers);
		if(autentification.isAutentificationBasic()){
			final XML xml = new Facility();
			return xml.getContent();
		}else{
			return "401 Las credenciales del usuario no son correctas";
		}
	}

}