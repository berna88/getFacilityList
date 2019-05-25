package com.consistent.facilities.models;

import com.consistent.facility.interfaces.XML;
import com.consistent.facility.portal.Portal;

public class Facility extends Portal implements XML{

	@Override
	public String getMapping() {
		
		String devueltos = String.valueOf(getFacilities().size());
		return devueltos;
	}
	
	
}
