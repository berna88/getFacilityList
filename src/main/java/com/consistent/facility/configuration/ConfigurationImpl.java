package com.consistent.facility.configuration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import com.consistent.facility.constants.Constants;
import com.consistent.facility.interfaces.Configuration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Component(
		immediate=true,
		configurationPid = "com.consistent.facility.interfaces.Configuration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		property={"jaxrs.application=true"}
		)
 
public class ConfigurationImpl {
	
	private static final Log log = LogFactoryUtil.getLog(ConfigurationImpl.class);
	
	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		
		log.info("Configuration");
		configuration = ConfigurableUtil.createConfigurable(Configuration.class, properties);
		
		try{
			if(configuration!=null){
				//Facility
				if(configuration.getFacilityId()!=null){
					Constants.FACILITY_ID = configuration.getFacilityId();
					log.info("Configuration Facility_Id "+Constants.FACILITY_ID);
				}else{
					log.info("Configuration Facility_Id is null "+Constants.FACILITY_ID);
				}
				//Restaurant
				if(configuration.getRestaurantId()!=null){
					Constants.RESTAURANTE_ID = configuration.getRestaurantId();
					log.info("Configuration Restaurant_Id "+Constants.RESTAURANTE_ID);
				}else{
					log.info("Configuration Restaurant_Id is null "+Constants.RESTAURANTE_ID);
				}
				//Meeting Room
				if(configuration.getMeetingRoomId()!=null){
					Constants.MEETING_ROOM_ID = configuration.getMeetingRoomId();
					log.info("Configuration Meeting_Room_Id "+Constants.MEETING_ROOM_ID);
				}else{
					log.info("Configuration Meeting_Room_Id is null "+Constants.MEETING_ROOM_ID);
				}
				//FiestaKidsClub
				if(configuration.getFiestaKidsClubId()!=null){
					Constants.FIESTA_KIDS_CLUB_ID = configuration.getFiestaKidsClubId();
					log.info("Configuration FiestaKidsClub_Id "+Constants.FIESTA_KIDS_CLUB_ID);
				}else{
					log.info("Configuration FiestaKidsClub_Id is null "+Constants.FIESTA_KIDS_CLUB_ID);
				}
				//Spa
				if(configuration.getSpaId()!=null){
					Constants.SPA_ID = configuration.getSpaId();
					log.info("Configuration Spa_Id "+Constants.SPA_ID);
				}else{
					log.info("Configuration Spa_Id is null "+Constants.SPA_ID);
				}
				//Gym
				if(configuration.getGymId()!=null){
					Constants.GYM_ID = configuration.getGymId();
					log.info("Configuration Gym_Id "+Constants.GYM_ID);
				}else{
					log.info("Configuration Gym_Id is null "+Constants.GYM_ID);
				}
				//Bar
				if(configuration.getBarId()!=null){
					Constants.BAR_ID = configuration.getBarId();
					log.info("Configuration Bar_Id "+Constants.BAR_ID);
				}else{
					log.info("Configuration Bar_Id is null "+Constants.BAR_ID);
				}
				 
			}else{
				log.info("The sample DXP REST config object is not yet initialized");
			}
		}catch (NullPointerException e) {
			// TODO: handle exception
			log.error("Error en el activate Metodo Active "+e);
		}
	}
	
	private Configuration configuration;
}
