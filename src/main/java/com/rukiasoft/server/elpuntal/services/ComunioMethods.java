package com.rukiasoft.server.elpuntal.services;

import java.util.List;

import com.google.gson.JsonObject;
import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.database.ComunioDAO;
import com.rukiasoft.server.elpuntal.database.ComunioDAOSQL;
import com.rukiasoft.server.elpuntal.utils.Constants;
import com.rukiasoft.server.elpuntal.utils.Tools;


public class ComunioMethods {
	
	private ComunioDAO comunioDAO;
	
	private ComunioDAO getComunioDAO(){
		//aquí la lógica que qué tipo de database cojo
		if(comunioDAO == null){
			comunioDAO = new ComunioDAOSQL();
		}
		return comunioDAO;
	}
	
	public List<Participant> getParticipants(){
		return getComunioDAO().getParticipants();
	}
	
	public JsonObject getParticipantsAsJSON(){
		List<Participant> list = getParticipants();
		Tools mTools = new Tools();
		JsonObject response = mTools.getJSONObjectFromArrayList(Constants.FIELD_PARTICIPANTS,
				list);
		return response;
	}
	

}
