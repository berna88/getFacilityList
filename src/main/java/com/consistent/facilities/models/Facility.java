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
	private String descriptionComplete;
	private String type;
	private String schedule;
	private String treatmentsSpa;
	private String typeFoodRestaurant;
	private String dresscodeRestaurant;
	private String capacityRestaurant;
	private String allInclusiveRestaurant;
	private String nameFiestaKids;
	private String capacityBar;
	private String AllInclusiveBar;
	private String numberOfRooms;
	private String occupationMaximaMeetingRoom;
	private String schedulesGym;
	private String yoga;
	private String aquaerobics;
	private String zumba;
	private String caminata;
	private String pingPong;
	private String juegosDeDardos;
	private String mesaDeBillar;
	private String bingo;
	private String juegosDeMesa;
	private String clasesDeCocina;
	private String clasesDeBaile;
	private String clubDePlaya;
	private String juegosDePlaya;
	private String musicaEnVivo;
	private String rentaDeBicicletas;
	private String excursiones;
	private String tours;
	private String snorkel;
	private String kayak;
	private String buceo;
	private String catamaranyVelero;
	private String pesca;
	private String actividadesMaritimas;
	private String paddleBoard;
	private String deportesMotorizados;
	private String casino;
	private String paseoACaballo;
	private String cataDeVinoTequila;
	private String cursosDeGolf;
	private String contenedorActivities;
	
	
	
	public String getContenedorActivities() {
		return contenedorActivities;
	}
	public void setContenedorActivities(String contenedorActivities) {
		this.contenedorActivities = contenedorActivities;
	}
	public String getBingo() {
		return bingo;
	}
	public void setBingo(String bingo) {
		this.bingo = bingo;
	}
	public String getPingPong() {
		return pingPong;
	}
	public void setPingPong(String pingPong) {
		this.pingPong = pingPong;
	}
	public String getJuegosDeDardos() {
		return juegosDeDardos;
	}
	public void setJuegosDeDardos(String juegosDeDardos) {
		this.juegosDeDardos = juegosDeDardos;
	}
	public String getMesaDeBillar() {
		return mesaDeBillar;
	}
	public void setMesaDeBillar(String mesaDeBillar) {
		this.mesaDeBillar = mesaDeBillar;
	}
	public String getJuegosDeMesa() {
		return juegosDeMesa;
	}
	public void setJuegosDeMesa(String juegosDeMesa) {
		this.juegosDeMesa = juegosDeMesa;
	}
	public String getClasesDeCocina() {
		return clasesDeCocina;
	}
	public void setClasesDeCocina(String clasesDeCocina) {
		this.clasesDeCocina = clasesDeCocina;
	}
	public String getClasesDeBaile() {
		return clasesDeBaile;
	}
	public void setClasesDeBaile(String clasesDeBaile) {
		this.clasesDeBaile = clasesDeBaile;
	}
	public String getClubDePlaya() {
		return clubDePlaya;
	}
	public void setClubDePlaya(String clubDePlaya) {
		this.clubDePlaya = clubDePlaya;
	}
	public String getJuegosDePlaya() {
		return juegosDePlaya;
	}
	public void setJuegosDePlaya(String juegosDePlaya) {
		this.juegosDePlaya = juegosDePlaya;
	}
	public String getMusicaEnVivo() {
		return musicaEnVivo;
	}
	public void setMusicaEnVivo(String musicaEnVivo) {
		this.musicaEnVivo = musicaEnVivo;
	}
	public String getRentaDeBicicletas() {
		return rentaDeBicicletas;
	}
	public void setRentaDeBicicletas(String rentaDeBicicletas) {
		this.rentaDeBicicletas = rentaDeBicicletas;
	}
	public String getExcursiones() {
		return excursiones;
	}
	public void setExcursiones(String excursiones) {
		this.excursiones = excursiones;
	}
	public String getTours() {
		return tours;
	}
	public void setTours(String tours) {
		this.tours = tours;
	}
	public String getSnorkel() {
		return snorkel;
	}
	public void setSnorkel(String snorkel) {
		this.snorkel = snorkel;
	}
	public String getKayak() {
		return kayak;
	}
	public void setKayak(String kayak) {
		this.kayak = kayak;
	}
	public String getBuceo() {
		return buceo;
	}
	public void setBuceo(String buceo) {
		this.buceo = buceo;
	}
	public String getCatamaranyVelero() {
		return catamaranyVelero;
	}
	public void setCatamaranyVelero(String catamaranyVelero) {
		this.catamaranyVelero = catamaranyVelero;
	}
	public String getPesca() {
		return pesca;
	}
	public void setPesca(String pesca) {
		this.pesca = pesca;
	}
	public String getActividadesMaritimas() {
		return actividadesMaritimas;
	}
	public void setActividadesMaritimas(String actividadesMaritimas) {
		this.actividadesMaritimas = actividadesMaritimas;
	}
	public String getPaddleBoard() {
		return paddleBoard;
	}
	public void setPaddleBoard(String paddleBoard) {
		this.paddleBoard = paddleBoard;
	}
	public String getDeportesMotorizados() {
		return deportesMotorizados;
	}
	public void setDeportesMotorizados(String deportesMotorizados) {
		this.deportesMotorizados = deportesMotorizados;
	}
	public String getCasino() {
		return casino;
	}
	public void setCasino(String casino) {
		this.casino = casino;
	}
	public String getPaseoACaballo() {
		return paseoACaballo;
	}
	public void setPaseoACaballo(String paseoACaballo) {
		this.paseoACaballo = paseoACaballo;
	}
	public String getCataDeVinoTequila() {
		return cataDeVinoTequila;
	}
	public void setCataDeVinoTequila(String cataDeVinoTequila) {
		this.cataDeVinoTequila = cataDeVinoTequila;
	}
	public String getCursosDeGolf() {
		return cursosDeGolf;
	}
	public void setCursosDeGolf(String cursosDeGolf) {
		this.cursosDeGolf = cursosDeGolf;
	}
	public String getYoga() {
		return yoga;
	}
	public void setYoga(String yoga) {
		this.yoga = yoga;
	}
	public String getAquaerobics() {
		return aquaerobics;
	}
	public void setAquaerobics(String aquaerobics) {
		this.aquaerobics = aquaerobics;
	}
	public String getZumba() {
		return zumba;
	}
	public void setZumba(String zumba) {
		this.zumba = zumba;
	}
	public String getCaminata() {
		return caminata;
	}
	public void setCaminata(String caminata) {
		this.caminata = caminata;
	}
	
	public String getDescriptionComplete() {
		return descriptionComplete;
	}
	public void setDescriptionComplete(String descriptionComplete) {
		this.descriptionComplete = descriptionComplete;
	}
	
	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getSchedulesGym() {
		return schedulesGym;
	}

	public void setSchedulesGym(String schedulesGym) {
		this.schedulesGym = schedulesGym;
	}

	public String getSalaDeReuniones() {
		return numberOfRooms;
	}

	public void setSalaDeReuniones(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getOccupationMaximaMeetingRoom() {
		return occupationMaximaMeetingRoom;
	}

	public void setOccupationMaximaMeetingRoom(String occupationMaximaMeetingRoom) {
		this.occupationMaximaMeetingRoom = occupationMaximaMeetingRoom;
	}

	public String getAllInclusiveBar() {
		return AllInclusiveBar;
	}

	public void setAllInclusiveBar(String allInclusiveBar) {
		AllInclusiveBar = allInclusiveBar;
	}

	public String getCapacityBar() {
		return capacityBar;
	}

	public void setCapacityBar(String capacityBar) {
		this.capacityBar = capacityBar;
	}

	public String getNameFiestaKids() {
		return nameFiestaKids;
	}

	public void setNameFiestaKids(String nameFiestaKids) {
		this.nameFiestaKids = nameFiestaKids;
	}

	public String getDresscodeRestaurant() {
		return dresscodeRestaurant;
	}

	public void setDresscodeRestaurant(String dresscodeRestaurant) {
		this.dresscodeRestaurant = dresscodeRestaurant;
	}

	public String getCapacityRestaurant() {
		return capacityRestaurant;
	}

	public void setCapacityRestaurant(String capacityRestaurant) {
		this.capacityRestaurant = capacityRestaurant;
	}

	public String getAllInclusiveRestaurant() {
		return allInclusiveRestaurant;
	}

	public void setAllInclusiveRestaurant(String allInclusiveRestaurant) {
		this.allInclusiveRestaurant = allInclusiveRestaurant;
	}
	private List<String> medialinks;
	
	public String getTypeFoodRestaurant() {
		return typeFoodRestaurant;
	}
	
	public void setTypeFoodRestaurant(String typeFoodRestaurant) {
		this.typeFoodRestaurant = typeFoodRestaurant;
	}
	
	public String getTreatmentsSpa(){
		return treatmentsSpa;
	}
	
	public void setTreatmentsSpa(String treatmentsSpa) {
		this.treatmentsSpa = treatmentsSpa;
	}
	
	public String getSchedule() {
		return schedule;
	}
	
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
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
			String descriptionComplete, String type, String schedule, String treatmentsSpa, String typeFoodRestaurant,
			String dresscodeRestaurant, String capacityRestaurant, String allInclusiveRestaurant, String nameFiestaKids,
			String capacityBar, String allInclusiveBar, String numberOfRooms, String occupationMaximaMeetingRoom,
			String schedulesGym, String yoga, String aquaerobics, String zumba, String caminata, String pingPong,
			String juegosDeDardos, String mesaDeBillar, String bingo, String juegosDeMesa, String clasesDeCocina,
			String clasesDeBaile, String clubDePlaya, String juegosDePlaya, String musicaEnVivo,
			String rentaDeBicicletas, String excursiones, String tours, String snorkel, String kayak, String buceo,
			String catamaranyVelero, String pesca, String actividadesMaritimas, String paddleBoard,
			String deportesMotorizados, String casino, String paseoACaballo, String cataDeVinoTequila,
			String cursosDeGolf, List<String> medialinks) {
		super();
		this.guid = guid;
		this.name = name;
		this.title = title;
		this.language = language;
		this.keyword = keyword;
		this.description = description;
		this.descriptionComplete = descriptionComplete;
		this.type = type;
		this.schedule = schedule;
		this.treatmentsSpa = treatmentsSpa;
		this.typeFoodRestaurant = typeFoodRestaurant;
		this.dresscodeRestaurant = dresscodeRestaurant;
		this.capacityRestaurant = capacityRestaurant;
		this.allInclusiveRestaurant = allInclusiveRestaurant;
		this.nameFiestaKids = nameFiestaKids;
		this.capacityBar = capacityBar;
		AllInclusiveBar = allInclusiveBar;
		this.numberOfRooms = numberOfRooms;
		this.occupationMaximaMeetingRoom = occupationMaximaMeetingRoom;
		this.schedulesGym = schedulesGym;
		this.yoga = yoga;
		this.aquaerobics = aquaerobics;
		this.zumba = zumba;
		this.caminata = caminata;
		this.pingPong = pingPong;
		this.juegosDeDardos = juegosDeDardos;
		this.mesaDeBillar = mesaDeBillar;
		this.bingo = bingo;
		this.juegosDeMesa = juegosDeMesa;
		this.clasesDeCocina = clasesDeCocina;
		this.clasesDeBaile = clasesDeBaile;
		this.clubDePlaya = clubDePlaya;
		this.juegosDePlaya = juegosDePlaya;
		this.musicaEnVivo = musicaEnVivo;
		this.rentaDeBicicletas = rentaDeBicicletas;
		this.excursiones = excursiones;
		this.tours = tours;
		this.snorkel = snorkel;
		this.kayak = kayak;
		this.buceo = buceo;
		this.catamaranyVelero = catamaranyVelero;
		this.pesca = pesca;
		this.actividadesMaritimas = actividadesMaritimas;
		this.paddleBoard = paddleBoard;
		this.deportesMotorizados = deportesMotorizados;
		this.casino = casino;
		this.paseoACaballo = paseoACaballo;
		this.cataDeVinoTequila = cataDeVinoTequila;
		this.cursosDeGolf = cursosDeGolf;
		this.medialinks = medialinks;
	}
	public Facility(){
		this.guid = "";
		this.name = "";
		this.title = "";
		this.language = "";
		this.keyword = "";
		this.description = "";
		this.descriptionComplete = "";
		this.type = "";
		this.schedule = "";
		this.treatmentsSpa = "";
		this.typeFoodRestaurant = "";
		this.dresscodeRestaurant = "";
		this.capacityRestaurant = "";
		this.allInclusiveRestaurant = "";
		this.nameFiestaKids = "";
		this.capacityBar = "";
		AllInclusiveBar = "";
		this.numberOfRooms = "";
		this.occupationMaximaMeetingRoom = "";
		this.schedulesGym = "";
		this.yoga = "";
		this.aquaerobics = "";
		this.zumba = "";
		this.caminata = "";
		this.pingPong = "";
		this.juegosDeDardos = "";
		this.mesaDeBillar = "";
		this.bingo = "";
		this.juegosDeMesa = "";
		this.clasesDeCocina = "";
		this.clasesDeBaile = "";
		this.clubDePlaya = "";
		this.juegosDePlaya = "";
		this.musicaEnVivo = "";
		this.rentaDeBicicletas = "";
		this.excursiones = "";
		this.tours = "";
		this.snorkel = "";
		this.kayak = "";
		this.buceo = "";
		this.catamaranyVelero = "";
		this.pesca = "";
		this.actividadesMaritimas = "";
		this.paddleBoard = "";
		this.deportesMotorizados = "";
		this.casino = "";
		this.paseoACaballo = "";
		this.cataDeVinoTequila = "";
		this.cursosDeGolf = "";
		this.medialinks = new ArrayList<String>();
		this.contenedorActivities = "";
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
					xMLStreamWriter.writeStartElement("description_BEP");
						xMLStreamWriter.writeDTD(description);
					xMLStreamWriter.writeEndElement();
					xMLStreamWriter.writeStartElement("description");
						xMLStreamWriter.writeDTD(descriptionComplete);
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
					
		
		
		if (type.equals(TYPE_SPA)) {
			if (schedule != null) {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters(schedule);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters("");
				xMLStreamWriter.writeEndElement();
			}
			if (treatmentsSpa != null) {
				xMLStreamWriter.writeStartElement("treatmentsSpa");
				xMLStreamWriter.writeDTD(treatmentsSpa);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("treatmentsSpa");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
		}

		if (type.equals(TYPE_RESTAURANT)) {
			
			if (schedule != null) {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters(schedule);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters("");
				xMLStreamWriter.writeEndElement();
			}

			if (typeFoodRestaurant != null) {
				xMLStreamWriter.writeStartElement("typeFoodRestaurant");
				xMLStreamWriter.writeDTD(typeFoodRestaurant);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("typeFoodRestaurant");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
			if (dresscodeRestaurant != null) {
				xMLStreamWriter.writeStartElement("dresscodeRestaurant");
				xMLStreamWriter.writeDTD(dresscodeRestaurant);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("dresscodeRestaurant");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
			if (capacityRestaurant != null) {
				xMLStreamWriter.writeStartElement("capacityRestaurant");
				xMLStreamWriter.writeDTD(capacityRestaurant);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("capacityRestaurant");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
			if (allInclusiveRestaurant != null) {
				xMLStreamWriter.writeStartElement("allInclusiveRestaurant");
				xMLStreamWriter.writeDTD(allInclusiveRestaurant);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("allInclusiveRestaurant");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}

		}
		if (type.equals(TYPE_FIESTAKIDSCLUB)) {
			if (schedule != null) {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters(schedule);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters("");
				xMLStreamWriter.writeEndElement();
			}
			if (nameFiestaKids != null) {
				xMLStreamWriter.writeStartElement("nameFiestaKids");
				xMLStreamWriter.writeDTD(nameFiestaKids);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("nameFiestaKids");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
		}
		if (type.equals(TYPE_BAR)) {
			if (schedule != null) {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters(schedule);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters("");
				xMLStreamWriter.writeEndElement();
			}
			if (capacityBar != null) {
				xMLStreamWriter.writeStartElement("capacityBar");
				xMLStreamWriter.writeDTD(capacityBar);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("capacityBar");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
			if (AllInclusiveBar != null) {
				xMLStreamWriter.writeStartElement("AllInclusiveBar");
				xMLStreamWriter.writeDTD(AllInclusiveBar);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("AllInclusiveBar");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
		}
		if (type.equals("Meeting room") || type.equals("Sala de reuniones")) {
			if (numberOfRooms != null) {
				xMLStreamWriter.writeStartElement("numberOfRooms");
				xMLStreamWriter.writeDTD(numberOfRooms);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("numberOfRooms");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
			if (occupationMaximaMeetingRoom != null) {
				xMLStreamWriter.writeStartElement("occupationMaximaMeetingRoom");
				xMLStreamWriter.writeDTD(occupationMaximaMeetingRoom);
				xMLStreamWriter.writeEndElement();
			} else {
				xMLStreamWriter.writeStartElement("occupationMaximaMeetingRoom");
				xMLStreamWriter.writeDTD("");
				xMLStreamWriter.writeEndElement();
			}
		}
		if(type.equals("Gimnasio") || type.equals("Gym")) {
			if (schedule != null) {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters(schedule);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("schedule");
				xMLStreamWriter.writeCharacters("");
				xMLStreamWriter.writeEndElement();
			}
		}
		
		if(type.equalsIgnoreCase("Activities")) {
			if (yoga != null && !yoga.isEmpty()) {
				xMLStreamWriter.writeStartElement("yoga");
				xMLStreamWriter.writeCharacters(yoga);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("yoga");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
	
			if (aquaerobics != null && !aquaerobics.isEmpty()) {
				xMLStreamWriter.writeStartElement("aquaerobics");
				xMLStreamWriter.writeCharacters(aquaerobics);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("aquaerobics");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (zumba != null && !zumba.isEmpty()) {
				xMLStreamWriter.writeStartElement("zumba");
				xMLStreamWriter.writeCharacters(zumba);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("zumba");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (caminata != null && !caminata.isEmpty()) {
				xMLStreamWriter.writeStartElement("trekking");
				xMLStreamWriter.writeCharacters(caminata);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("trekking");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (pingPong != null && !pingPong.isEmpty()) {
				xMLStreamWriter.writeStartElement("pingPong");
				xMLStreamWriter.writeCharacters(pingPong);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("pingPong");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (juegosDeDardos != null && !juegosDeDardos.isEmpty()) {
				xMLStreamWriter.writeStartElement("dartsGames");
				xMLStreamWriter.writeCharacters(juegosDeDardos);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("dartsGames");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
	
			if (mesaDeBillar != null && !mesaDeBillar.isEmpty()) {
				xMLStreamWriter.writeStartElement("billiardTable");
				xMLStreamWriter.writeCharacters(mesaDeBillar);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("billiardTable");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (bingo != null && !bingo.isEmpty()) {
				xMLStreamWriter.writeStartElement("bingo");
				xMLStreamWriter.writeCharacters(bingo);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("bingo");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (juegosDeMesa != null && !juegosDeMesa.isEmpty()) {
				xMLStreamWriter.writeStartElement("boardGames");
				xMLStreamWriter.writeCharacters(juegosDeMesa);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("boardGames");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (clasesDeCocina != null && !clasesDeCocina.isEmpty()) {
				xMLStreamWriter.writeStartElement("cookingClass");
				xMLStreamWriter.writeCharacters(clasesDeCocina);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("cookingClass");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (clasesDeBaile != null && !clasesDeBaile.isEmpty()) {
				xMLStreamWriter.writeStartElement("danceLessons");
				xMLStreamWriter.writeCharacters(clasesDeBaile);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("danceLessons");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (clubDePlaya != null && !clubDePlaya.isEmpty()) {
				xMLStreamWriter.writeStartElement("beachClub");
				xMLStreamWriter.writeCharacters(clubDePlaya);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("beachClub");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (juegosDePlaya != null && !juegosDePlaya.isEmpty()) {
				xMLStreamWriter.writeStartElement("beachGames");
				xMLStreamWriter.writeCharacters(juegosDePlaya);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("beachGames");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (musicaEnVivo != null && !musicaEnVivo.isEmpty()) {
				xMLStreamWriter.writeStartElement("liveMusic");
				xMLStreamWriter.writeCharacters(musicaEnVivo);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("liveMusic");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (rentaDeBicicletas != null && !rentaDeBicicletas.isEmpty()) {
				xMLStreamWriter.writeStartElement("bicycleRental");
				xMLStreamWriter.writeCharacters(rentaDeBicicletas);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("bicycleRental");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (excursiones != null && !excursiones.isEmpty()) {
				xMLStreamWriter.writeStartElement("excursions");
				xMLStreamWriter.writeCharacters(excursiones);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("excursions");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (tours != null && !tours.isEmpty()) {
				xMLStreamWriter.writeStartElement("tours");
				xMLStreamWriter.writeCharacters(tours);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("tours");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (snorkel != null && !snorkel.isEmpty()) {
				xMLStreamWriter.writeStartElement("snorkel");
				xMLStreamWriter.writeCharacters(snorkel);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("snorkel");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (kayak != null && !kayak.isEmpty()) {
				xMLStreamWriter.writeStartElement("kayak");
				xMLStreamWriter.writeCharacters(kayak);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("kayak");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (buceo != null && !buceo.isEmpty()) {
				xMLStreamWriter.writeStartElement("diving");
				xMLStreamWriter.writeCharacters(buceo);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("diving");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (catamaranyVelero != null && !catamaranyVelero.isEmpty()) {
				xMLStreamWriter.writeStartElement("catamaranAndSailboat");
				xMLStreamWriter.writeCharacters(catamaranyVelero);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("catamaranAndSailboat");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (pesca != null && !pesca.isEmpty()) {
				xMLStreamWriter.writeStartElement("fishing");
				xMLStreamWriter.writeCharacters(pesca);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("fishing");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (actividadesMaritimas != null && !actividadesMaritimas.isEmpty()) {
				xMLStreamWriter.writeStartElement("maritimeActivities");
				xMLStreamWriter.writeCharacters(actividadesMaritimas);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("maritimeActivities");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (paddleBoard != null && !paddleBoard.isEmpty()) {
				xMLStreamWriter.writeStartElement("paddleBoard");
				xMLStreamWriter.writeCharacters(paddleBoard);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("paddleBoard");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			

			if (deportesMotorizados != null && !deportesMotorizados.isEmpty()) {
				xMLStreamWriter.writeStartElement("motorizedSports");
				xMLStreamWriter.writeCharacters(deportesMotorizados);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("motorizedSports");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			
			if (casino != null && !casino.isEmpty()) {
				xMLStreamWriter.writeStartElement("casino");
				xMLStreamWriter.writeCharacters(casino);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("casino");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (paseoACaballo != null && !paseoACaballo.isEmpty()) {
				xMLStreamWriter.writeStartElement("horsebackRiding");
				xMLStreamWriter.writeCharacters(paseoACaballo);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("horsebackRiding");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (cataDeVinoTequila != null && !cataDeVinoTequila.isEmpty()) {
				xMLStreamWriter.writeStartElement("wineTequilaTasting");
				xMLStreamWriter.writeCharacters(cataDeVinoTequila);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("wineTequilaTasting");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
			if (cursosDeGolf != null && !cursosDeGolf.isEmpty()) {
				xMLStreamWriter.writeStartElement("golfCourses");
				xMLStreamWriter.writeCharacters(cursosDeGolf);
				xMLStreamWriter.writeEndElement();
			}else {
				xMLStreamWriter.writeStartElement("golfCourses");
				xMLStreamWriter.writeCharacters("false");
				xMLStreamWriter.writeEndElement();
			}
		}
		 
					
					
					
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
	 * @return Devuelve la lista de todos los facilities y filtrados
	 */
	private HashSet<String> getFacilitiesAll(){
		HashSet<String> articlesRecovery = new HashSet<>();
		int count = 0;
		
		try {
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticleImpl.class, "JournalArticle",PortalClassLoaderUtil.getClassLoader());
			if(com.consistent.facility.constants.Constants.KEYWORD==null){
				log.info("Sin filtro");
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
				log.info("Con filtro");
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
			e.printStackTrace();
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
		document = SAXReaderUtil.read(article.getContent());
		facility.name = document.valueOf("//dynamic-element[@name='nameFacility']/dynamic-content[@language-id='"+locale+"']/text()");
		facility.keyword = document.valueOf("//dynamic-element[@name='keywordFacility']/dynamic-content[@language-id='"+locale+"']/text()");
		facility.description = document.valueOf("//dynamic-element[@name='descriptionFacility']/dynamic-content[@language-id='"+locale+"']/text()");
		facility.description = facility.description.replaceAll("<div>", "");
		facility.description = facility.description.replaceAll("</div>", "");
		facility.description = facility.description.replaceAll("<p>", "");
		facility.description = facility.description.replaceAll("<p", "");
		facility.description = facility.description.replaceAll("</p>", "");
		facility.description = facility.description.replaceAll("<br />", "");
		facility.description = "<p>".concat(facility.description).concat("</p>");
		facility.descriptionComplete = facility.description;
		 
		facility.language = com.consistent.facility.constants.Constants.LANGUAGE;
		
		facility.type = article.getDDMStructure().getName(locale);
		
		facility.getValidData(facility, locale, document);
		
		if(facility.type.equals(TYPE_RESTAURANT)) {
			facility.description = 
					facility.description + 
					facility.typeFoodRestaurant +
					facility.schedule +
					facility.dresscodeRestaurant +
					facility.capacityRestaurant +
					facility.allInclusiveRestaurant;
		} else if(facility.type.equals(TYPE_BAR)) {
			facility.description = 
					facility.description + 
					facility.schedule +
					facility.capacityBar +
					facility.AllInclusiveBar;
		}else if(facility.type.equals(TYPE_FIESTAKIDSCLUB)) {
			facility.description = 
					facility.description + 
					facility.schedule +
					facility.nameFiestaKids;
		}else if(facility.type.equals("Sala de reuniones") || facility.type.equals("Meeting room")) {
			facility.description = 
					facility.description + 
					facility.numberOfRooms +
					facility.occupationMaximaMeetingRoom;
		}else if(facility.type.equals(TYPE_SPA)) {
			facility.description = 
					facility.description + 
					facility.schedule +
					facility.treatmentsSpa;
		}else if(facility.type.equals("Gimnasio") || facility.type.equals("Gym")) {
			facility.description = 
					facility.description + 
					facility.schedule;
		}else if(facility.type.equals(TYPE_ACTIVITIES)) {
			facility.description = 
					facility.description + 
					facility.contenedorActivities;
			log.info(" Con descripcion: "+facility.description);
		}
		
		  // Restaurante
		  facility.schedule = cleanBr(facility.schedule); 
		  facility.typeFoodRestaurant = cleanBr(facility.typeFoodRestaurant); 
		  facility.dresscodeRestaurant = cleanBr(facility.dresscodeRestaurant); 
		  facility.capacityRestaurant = cleanBr(facility.capacityRestaurant); 
		  facility.allInclusiveRestaurant = cleanBr(facility.allInclusiveRestaurant);
		  // Bar
		  facility.capacityBar = cleanBr(facility.capacityBar);
		  facility.AllInclusiveBar = cleanBr(facility.AllInclusiveBar);
		  // Spa
		  facility.treatmentsSpa = cleanBr(facility.treatmentsSpa);
		  // Sala de juntas 
		  facility.numberOfRooms = cleanBr(facility.numberOfRooms);
		  facility.occupationMaximaMeetingRoom = cleanBr(facility.occupationMaximaMeetingRoom);
		  // Fiesta kids
		  facility.nameFiestaKids = cleanBr(facility.nameFiestaKids);
		  
		//Medialinks
		List<Node> mediaNodes = document.selectNodes("//dynamic-element[@name='mediaLinksFacility']/dynamic-element");
		List<String> mediaArray = new ArrayList<String>();
		for (Node mediaNode : mediaNodes) {
			String pie = mediaNode.valueOf("dynamic-element[@name='footerMediaLinkFacility']/dynamic-content[@language-id='"+locale+"']/text()");
			String link = mediaNode.valueOf("dynamic-content/text()");
			String type_image = mediaNode.valueOf("dynamic-element[@name='typeFacility']/dynamic-content[@language-id='"+locale+"']/text()");
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
	
	private String validEmpty(String tagkey, String concat) {
		if(!tagkey.isEmpty()) {
			return "<p>"+concat+tagkey+"</p>";
		}
		return "";
	}
	private String validAllInclusive(String tagkey, String locale) {
		if(locale.equals("es_ES")) {
			if(tagkey.equals("true")) {
				return "<p>Todo incluido</p>";
			}else {
				return "";
			}
		}else if(locale.equals("en_US")) {
			if(tagkey.equals("true")) {
				return "<p>All inclusive</p>";
			}else {
				return "";
			}
		}else {
			return "";
		}
		
	}
	private String cleanBr(String tag) {
		if(tag != null) {
			tag = tag.replace("<p>", "");
			tag = tag.replace("</p>", "");
		}
		return tag;
	}
	
	private Facility getValidData(Facility facility, String locale, Document document) {
		if(locale.equals("es_ES")) {
			
			//Validando Activities
			if(facility.type.equalsIgnoreCase(ACTIVITIES)) {
				facility.yoga = document.valueOf("//dynamic-element[@name='Yoga']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.aquaerobics = document.valueOf("//dynamic-element[@name='Aquaerobics']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.zumba = document.valueOf("//dynamic-element[@name='Zumba']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.caminata = document.valueOf("//dynamic-element[@name='Caminata']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.pingPong = document.valueOf("//dynamic-element[@name='PingPong']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDeDardos = document.valueOf("//dynamic-element[@name='JuegosDeDardos']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.mesaDeBillar = document.valueOf("//dynamic-element[@name='MesaDeBillar']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.bingo = document.valueOf("//dynamic-element[@name='Bingo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDeMesa = document.valueOf("//dynamic-element[@name='JuegosDeMesa']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clasesDeCocina = document.valueOf("//dynamic-element[@name='ClasesDeCocina']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clasesDeBaile = document.valueOf("//dynamic-element[@name='ClasesDeBaile']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clubDePlaya = document.valueOf("//dynamic-element[@name='ClubDePlaya']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDePlaya = document.valueOf("//dynamic-element[@name='JuegosDePlaya']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.musicaEnVivo = document.valueOf("//dynamic-element[@name='MusicaEnVivo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.rentaDeBicicletas = document.valueOf("//dynamic-element[@name='RentaDeBicicletas']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.excursiones = document.valueOf("//dynamic-element[@name='Excursiones']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.tours = document.valueOf("//dynamic-element[@name='Tours']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.snorkel = document.valueOf("//dynamic-element[@name='Snorkel']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.kayak = document.valueOf("//dynamic-element[@name='Kayak']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.buceo = document.valueOf("//dynamic-element[@name='Buceo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.catamaranyVelero = document.valueOf("//dynamic-element[@name='CatamaranyVelero']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.pesca = document.valueOf("//dynamic-element[@name='Pesca']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.actividadesMaritimas = document.valueOf("//dynamic-element[@name='ActividadesMaritimas']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.paddleBoard = document.valueOf("//dynamic-element[@name='PaddleBoard']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.deportesMotorizados = document.valueOf("//dynamic-element[@name='DeportesMotorizados']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.casino = document.valueOf("//dynamic-element[@name='Casino']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.paseoACaballo = document.valueOf("//dynamic-element[@name='PaseoACaballo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.cataDeVinoTequila = document.valueOf("//dynamic-element[@name='CataDeVinoTequila']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.cursosDeGolf = document.valueOf("//dynamic-element[@name='CursosDeGolf']/dynamic-content[@language-id='"+locale+"']/text()");
				
				if(facility.yoga.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Yoga </p>";
				}
				if(facility.aquaerobics.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Aquaerobics </p>";
				}
				if(facility.zumba.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Zumba </p>";
				}
				if(facility.caminata.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Caminata </p>";
				}
				if(facility.pingPong.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Ping Pong </p>";
				}
				if(facility.juegosDeDardos.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Juegos de Dardos </p>";
				}
				if(facility.mesaDeBillar.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Mesa de billar </p>";
				}
				if(facility.bingo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Bingo </p>";
				}
				if(facility.juegosDeMesa.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Juegos de mesa </p>";
				}
				if(facility.clasesDeCocina.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Clases de cocina </p>";
				}
				if(facility.clasesDeBaile.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Clases de baile </p>";
				}
				if(facility.clubDePlaya.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Club de playa </p>";
				}
				if(facility.juegosDePlaya.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Juegos de playa </p>";
				}
				if(facility.musicaEnVivo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Musica en vivo </p>";
				}
				if(facility.rentaDeBicicletas.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Renta de bicicletas </p>";
				}
				if(facility.excursiones.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Excursiones </p>";
				}
				if(facility.tours.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Tours </p>";
				}
				if(facility.snorkel.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Snorkel </p>";
				}
				if(facility.kayak.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Kayak </p>";
				}
				if(facility.buceo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Buceo </p>";
				}
				if(facility.catamaranyVelero.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Catamaran y Velero </p>";
				}
				if(facility.actividadesMaritimas.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Actividades Maritimas </p>";
				}
				if(facility.paddleBoard.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Paddle Board </p>";
				}
				if(facility.deportesMotorizados.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Deportes Motorizados </p>";
				}
				if(facility.casino.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Casino </p>";
				}
				if(facility.paseoACaballo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Paseo a Caballo </p>";
				}
				if(facility.cataDeVinoTequila.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Cata de vino tequila </p>";
				}
				if(facility.cursosDeGolf.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Curso de golf </p>";
				}
				if(facility.pesca.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Pesca </p>";
				}
				
			}// fin de activities
			
			//Validando Horarios
			if(facility.type.equals("Fiesta Kids Club")) {
				if(!document.valueOf("//dynamic-element[@name='schedulesFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Horario: "+ document.valueOf("//dynamic-element[@name='schedulesFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				// Validando Fiesta kids
				facility.nameFiestaKids = validEmpty(document.valueOf("//dynamic-element[@name='nameFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()"), "Nombre: ");
			}
			
			if(facility.type.equals("Restaurant")) {
				if (!document.valueOf("//dynamic-element[@name='scheduleRestaurant']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Horario: "+ document.valueOf("//dynamic-element[@name='scheduleRestaurant']/dynamic-content[@language-id='"+locale+"']/text()")+ "</p>";
				} else {
					facility.schedule = "";
				}
				//Validando Restaurante
				
				facility.typeFoodRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='typeFoodRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Comida: ");
				
				facility.dresscodeRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='dresscodeRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Tipo de vestimenta: ");
				
				facility.capacityRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='capacityRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Capacidad: ");
						
				facility.allInclusiveRestaurant = validAllInclusive(document.valueOf("//dynamic-element[@name='allInclusiveRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), locale);	
			}
			
			if(facility.type.equals("Bar")) {
				if (!document.valueOf("//dynamic-element[@name='schedulesBar']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Horario: "+ document.valueOf("//dynamic-element[@name='schedulesBar']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				// Validando Bar
				facility.capacityBar = validEmpty(document.valueOf("//dynamic-element[@name='capacityBar']/dynamic-content[@language-id='"+locale+"']/text()"), "Capacidad: "); 
				facility.AllInclusiveBar = validAllInclusive(document.valueOf("//dynamic-element[@name='AllInclusive']/dynamic-content[@language-id='"+locale+"']/text()"),locale);
			}
			
			if(facility.type.equals("Sala de reuniones") || facility.type.equals("Meeting room")) {
				//Validando Sala de reuniones
				facility.numberOfRooms = validEmpty(document.valueOf("//dynamic-element[@name='SalaDeReuniones']/dynamic-content[@language-id='"+locale+"']/text()"), "Número de salas y/o salones: ");
				facility.occupationMaximaMeetingRoom = validEmpty(document.valueOf("//dynamic-element[@name='occupationMaximaMeetingRoom']/dynamic-content[@language-id='"+locale+"']/text()"),"Ocupación máxima: ");
			}
			
			if(facility.type.equals("Spa")) {
				if (!document.valueOf("//dynamic-element[@name='scheduleSpa']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Horario: "+document.valueOf("//dynamic-element[@name='scheduleSpa']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}
				//Validando Spa
				facility.treatmentsSpa = validEmpty(document.valueOf("//dynamic-element[@name='treatmentsSpa']/dynamic-content[@language-id='"+locale+"']/text()"),"Tratamientos: ");
			}
			
			if(facility.type.equals("Gimnasio") || facility.type.equals("Gym")) {
				if (!document.valueOf("//dynamic-element[@name='schedulesGym']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Horario: "+ document.valueOf("//dynamic-element[@name='schedulesGym']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}
			}
			
		}else if(locale.equals("en_US")) {
			
			//Validando Activities
			if(facility.type.equalsIgnoreCase(ACTIVITIES)) {
				facility.yoga = document.valueOf("//dynamic-element[@name='Yoga']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.aquaerobics = document.valueOf("//dynamic-element[@name='Aquaerobics']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.zumba = document.valueOf("//dynamic-element[@name='Zumba']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.caminata = document.valueOf("//dynamic-element[@name='Caminata']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.pingPong = document.valueOf("//dynamic-element[@name='PingPong']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDeDardos = document.valueOf("//dynamic-element[@name='JuegosDeDardos']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.mesaDeBillar = document.valueOf("//dynamic-element[@name='MesaDeBillar']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.bingo = document.valueOf("//dynamic-element[@name='Bingo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDeMesa = document.valueOf("//dynamic-element[@name='JuegosDeMesa']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clasesDeCocina = document.valueOf("//dynamic-element[@name='ClasesDeCocina']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clasesDeBaile = document.valueOf("//dynamic-element[@name='ClasesDeBaile']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.clubDePlaya = document.valueOf("//dynamic-element[@name='ClubDePlaya']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.juegosDePlaya = document.valueOf("//dynamic-element[@name='JuegosDePlaya']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.musicaEnVivo = document.valueOf("//dynamic-element[@name='MusicaEnVivo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.rentaDeBicicletas = document.valueOf("//dynamic-element[@name='RentaDeBicicletas']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.excursiones = document.valueOf("//dynamic-element[@name='Excursiones']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.tours = document.valueOf("//dynamic-element[@name='Tours']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.snorkel = document.valueOf("//dynamic-element[@name='Snorkel']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.kayak = document.valueOf("//dynamic-element[@name='Kayak']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.buceo = document.valueOf("//dynamic-element[@name='Buceo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.catamaranyVelero = document.valueOf("//dynamic-element[@name='CatamaranyVelero']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.pesca = document.valueOf("//dynamic-element[@name='Pesca']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.actividadesMaritimas = document.valueOf("//dynamic-element[@name='ActividadesMaritimas']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.paddleBoard = document.valueOf("//dynamic-element[@name='PaddleBoard']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.deportesMotorizados = document.valueOf("//dynamic-element[@name='DeportesMotorizados']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.casino = document.valueOf("//dynamic-element[@name='Casino']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.paseoACaballo = document.valueOf("//dynamic-element[@name='PaseoACaballo']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.cataDeVinoTequila = document.valueOf("//dynamic-element[@name='CataDeVinoTequila']/dynamic-content[@language-id='"+locale+"']/text()");
				facility.cursosDeGolf = document.valueOf("//dynamic-element[@name='CursosDeGolf']/dynamic-content[@language-id='"+locale+"']/text()");
				
				if(facility.yoga.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Yoga </p>";
				}
				if(facility.aquaerobics.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Aquaerobics </p>";
				}
				if(facility.zumba.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Zumba </p>";
				}
				if(facility.caminata.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Trekking </p>";
				}
				if(facility.pingPong.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Ping Pong </p>";
				}
				if(facility.juegosDeDardos.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Darts games </p>";
				}
				if(facility.mesaDeBillar.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> billiard table </p>";
				}
				if(facility.bingo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Bingo </p>";
				}
				if(facility.juegosDeMesa.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Board games </p>";
				}
				if(facility.clasesDeCocina.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Cooking class </p>";
				}
				if(facility.clasesDeBaile.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Dance lessons </p>";
				}
				if(facility.clubDePlaya.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Beach club </p>";
				}
				if(facility.juegosDePlaya.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Beach games </p>";
				}
				if(facility.musicaEnVivo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Live music </p>";
				}
				if(facility.rentaDeBicicletas.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Bicycle rental </p>";
				}
				if(facility.excursiones.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Excursions </p>";
				}
				if(facility.tours.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Tours </p>";
				}
				if(facility.snorkel.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Snorkel </p>";
				}
				if(facility.kayak.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Kayak </p>";
				}
				if(facility.buceo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Diving </p>";
				}
				if(facility.catamaranyVelero.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Catamaran and sailboat </p>";
				}
				if(facility.actividadesMaritimas.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Maritime activities </p>";
				}
				if(facility.paddleBoard.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Paddle Board </p>";
				}
				if(facility.deportesMotorizados.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Motorized sports </p>";
				}
				if(facility.casino.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Casino </p>";
				}
				if(facility.paseoACaballo.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Horseback riding </p>";
				}
				if(facility.cataDeVinoTequila.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Wine/tequila tasting </p>";
				}
				if(facility.cursosDeGolf.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Golf courses </p>";
				}
				if(facility.pesca.equalsIgnoreCase("true")) {
					facility.contenedorActivities += "<p> Fishing </p>";
				}
			}// fin de activities
			
			
			if(facility.type.equals("Fiesta Kids Club")) {
				//Validando Horarios
				if(!document.valueOf("//dynamic-element[@name='schedulesFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Schedule: "+ document.valueOf("//dynamic-element[@name='schedulesFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				// Validando Fiesta kids
				facility.nameFiestaKids = validEmpty(document.valueOf("//dynamic-element[@name='nameFiestaKids']/dynamic-content[@language-id='"+locale+"']/text()"), "Name: ");
			}
			
			if(facility.type.equals("Restaurant")) {
				if(!document.valueOf("//dynamic-element[@name='scheduleRestaurant']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Schedule: "+ document.valueOf("//dynamic-element[@name='scheduleRestaurant']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				
				//Validando Restaurante
				facility.typeFoodRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='typeFoodRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Food Type: ");
				facility.dresscodeRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='dresscodeRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Dresscode: ");
				facility.capacityRestaurant = validEmpty(document.valueOf("//dynamic-element[@name='capacityRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), "Capacity: ");		
				facility.allInclusiveRestaurant = validAllInclusive(document.valueOf("//dynamic-element[@name='allInclusiveRestaurant']/dynamic-content[@language-id='"+locale+"']/text()"), locale);
				
			}
			
			if(facility.type.equals("Bar")) {
				if(!document.valueOf("//dynamic-element[@name='schedulesBar']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Schedule: "+ document.valueOf("//dynamic-element[@name='schedulesBar']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				// Validando Bar
				facility.capacityBar = validEmpty(document.valueOf("//dynamic-element[@name='capacityBar']/dynamic-content[@language-id='"+locale+"']/text()"),"Capacity: "); 
				facility.AllInclusiveBar = validAllInclusive(document.valueOf("//dynamic-element[@name='AllInclusive']/dynamic-content[@language-id='"+locale+"']/text()"), locale);
			}
			
			if(facility.type.equals("Sala de reuniones") || facility.type.equals("Meeting room")) {
				//Validando Sala de reuniones
				facility.numberOfRooms = validEmpty(document.valueOf("//dynamic-element[@name='SalaDeReuniones']/dynamic-content[@language-id='"+locale+"']/text()"),"Number of meeting rooms: ");
				facility.occupationMaximaMeetingRoom = validEmpty(document.valueOf("//dynamic-element[@name='occupationMaximaMeetingRoom']/dynamic-content[@language-id='"+locale+"']/text()"),"Max Occupation: ");
			}
			
			if(facility.type.equals("Spa")) {
				if(!document.valueOf("//dynamic-element[@name='scheduleSpa']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {
					facility.schedule = "<p>Schedule: "+ document.valueOf("//dynamic-element[@name='scheduleSpa']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
				//Validando Spa
				
				facility.treatmentsSpa = validEmpty(document.valueOf("//dynamic-element[@name='treatmentsSpa']/dynamic-content[@language-id='"+locale+"']/text()"), "Treatments: ");
				
			}
			
			if(facility.type.equals("Gimnasio") || facility.type.equals("Gym")) {
				if(!document.valueOf("//dynamic-element[@name='schedulesGym']/dynamic-content[@language-id='"+locale+"']/text()").isEmpty()) {		
					facility.schedule = "<p>Schedule: "+ document.valueOf("//dynamic-element[@name='schedulesGym']/dynamic-content[@language-id='"+locale+"']/text()") + "</p>";
				}else {
					facility.schedule = "";
				}
			}
			
		}
		return facility;
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
		case ACTIVITIES:
			log.info(ACTIVITIES);
			results = DDMStructureLocalServiceUtil.getStructure(com.consistent.facility.constants.Constants.ACTIVITIES_ID);
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
