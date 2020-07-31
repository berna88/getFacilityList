package com.consistent.facility.constants;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class Constants {
	
	private static final Log log = LogFactoryUtil.getLog(Constants.class);
	
	public static Long GROUP_ID = null;
	public static String LANGUAGE = "";
	public static String HOTEL_CODE = "";
	public static String KEYWORD = "";
	
	// Identificadores de estructuras
	public static Long RESTAURANTE_ID = null;
	public static Long FACILITY_ID = null;
	public static Long MEETING_ROOM_ID = null;
	public static Long FIESTA_KIDS_CLUB_ID = null;
	public static Long SPA_ID = null;
	public static Long GYM_ID = null;
	public static Long BAR_ID = null;
	public static Long ACTIVITIES_ID = null;
	//Metodo para obtener el locate
	public static String getLanguaje(){			
		if(LANGUAGE.equalsIgnoreCase("spanish")){
			return  "es_ES";
		}else if(LANGUAGE.equalsIgnoreCase("english")){
			return "en_US";
		}else {
			log.info("No se establecio un lenguaje valido");
		}
		return new String();			
	}
}
