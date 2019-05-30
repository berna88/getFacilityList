package com.consistent.facility.interfaces;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "Posadas", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD( localization = "content/Language",id = "com.consistent.facility.interfaces.Configuration",name = "Service FacilityList")
public interface Configuration {
	
	@Meta.AD(required = false,description = "Get Struture Restaurant id", deflt="0")
    public Long getRestaurantId();
	
	@Meta.AD(required = false,description = "Get Struture Facility id", deflt="0")
    public Long getFacilityId();
	
	@Meta.AD(required = false,description = "Get Struture Meeting Room id", deflt="0")
    public Long getMeetingRoomId();
	
	@Meta.AD(required = false,description = "Get Struture FiestaKidsClub id", deflt="0")
    public Long getFiestaKidsClubId();
	
	@Meta.AD(required = false,description = "Get Struture Spa id", deflt="0")
    public Long getSpaId();
	
	@Meta.AD(required = false,description = "Get Struture Gym id", deflt="0")
    public Long getGymId();
	
	@Meta.AD(required = false,description = "Get Struture Bar id", deflt="0")
    public Long getBarId();
}
