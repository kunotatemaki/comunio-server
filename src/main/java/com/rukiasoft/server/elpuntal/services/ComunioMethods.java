package com.rukiasoft.server.elpuntal.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rukiasoft.server.elpuntal.classes.Configuration;
import com.rukiasoft.server.elpuntal.classes.Log;
import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.classes.Round;
import com.rukiasoft.server.elpuntal.classes.Score;
import com.rukiasoft.server.elpuntal.classes.Signing;
import com.rukiasoft.server.elpuntal.classes.Team;
import com.rukiasoft.server.elpuntal.database.ComunioDAO;
import com.rukiasoft.server.elpuntal.database.ComunioDAOSQL;
import com.rukiasoft.server.elpuntal.utils.Constants;
import com.rukiasoft.server.elpuntal.utils.Tools;

import ruler.elpuntal.comunio.server.classes.ComunioConstants;


public class ComunioMethods {
	
	private static ComunioDAO comunioDAO;
	private static Configuration conf = null;
	
	private static ComunioDAO getComunioDAO(){
		//aquí la lógica que qué tipo de database cojo
		if(comunioDAO == null){
			comunioDAO = new ComunioDAOSQL();
		}
		return comunioDAO;
	}
	
	
	
	public static Configuration getConf() {
		if(conf == null){
			conf = loadConf();
		}
		return conf;
	}
	
	private static Configuration loadConf(){
		return getComunioDAO().getConf();
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
	
	
	public JsonObject getPageDataAsJSON(){
		JsonObject response= new JsonObject();
		
		//Participantes
		List<Participant> listParticipants = getParticipants();
		Tools mTools = new Tools();
		JsonArray jsonParticipants = mTools.getJSONArrayFromArrayList(listParticipants);
		response.add(Constants.FIELD_PARTICIPANTS, jsonParticipants);
		
		//puntuaciones
		JsonArray jsonArrayScores = new JsonArray();
		for(int i=0; i<listParticipants.size(); i++) {
			List<Score> listPuntuacion = getRoundInformation(listParticipants.get(i), Constants.ALL_ROUNDS);
			JsonObject jsonScoreParticipant = mTools.getJSONObjectFromArrayList(listParticipants.get(i).getTableName(),
					listPuntuacion);
			jsonArrayScores.add(jsonScoreParticipant);
		}
		response.add(Constants.FIELD_SCORES, jsonArrayScores);
		
		//Fichajes
		List<Signing> signings = getComunioDAO().getSigningInformation(Constants.ALL_SIGNINGS);
		JsonArray jsonSignings = mTools.getJSONArrayFromArrayList(signings);
		response.add(Constants.FIELD_SIGNINGS, jsonSignings);
		
		//Logs
		List<Log> logs = getComunioDAO().getLogs();
		JsonArray jsonLogs = mTools.getJSONArrayFromArrayList(logs);
		response.add(Constants.FIELD_LOGS, jsonLogs);
		
		//teams
		List<String> listTeams = getList(Constants.FIELD_TEAMS);
		JsonArray jsonTeams = new JsonArray();
		for(int i=0; i<listTeams.size(); i++){
			jsonTeams.add(listTeams.get(i));
		}
		response.add(Constants.FIELD_TEAMS, jsonTeams);
		
		//Other values
		response.addProperty(Constants.FIELD_COMPUTER, Constants.COMPUTER);
		
		//demarcaciones
		List<String> listPlayerPosition = getList(Constants.PLAYING_POSITION);
		JsonArray jsonPlayerPosition = new JsonArray();
		for(int i=0; i<listPlayerPosition.size(); i++){
			jsonPlayerPosition.add(listPlayerPosition.get(i));
		}
		response.add(Constants.PLAYING_POSITION, jsonPlayerPosition);

		//sanciones
		List<String> listPenalties = getList(Constants.PENALTIES);
		JsonArray jsonPenalties = new JsonArray();
		for(int i=0; i<listPenalties.size(); i++){
			jsonPenalties.add(listPenalties.get(i));
		}
		response.add(Constants.PENALTIES, jsonPenalties);
		
		responseX.put("sancionados", searchForRemo());
		//configuraciones
		JsonObject jsonConfiguration = new JsonObject();
		Gson gson = new Gson();
		response.addProperty(Constants.CONFIGURATION, getConf());
		responseX.put(ComunioConstants.CURRENT_ROUND, getCurrentRound().getValor());
		responseX.put(ComunioConstants.NEXT_ROUND, getNextRound().getValor());
		responseX.put(ComunioConstants.START_ROUND, conf.getjInicial());
		responseX.put(ComunioConstants.FINAL_ROUND, conf.getjFinal());
		responseX.put(ComunioConstants.BONUS_GOAL, conf.getPrimaGol());
		responseX.put(ComunioConstants.BONUS_GOALKEEPER, conf.getPrimaPortero());
		responseX.put(ComunioConstants.BONUS_LAST_IN_ROUND, conf.getPrimaTorpeJornada());
		responseX.put(ComunioConstants.BONUS_LAST_IN_CLASSIFICATION, conf.getPrimaTorpeGeneral());
		responseX.put(ComunioConstants.REMO_MAX_PLAYERS, conf.getRemoMaxJugadores());
		responseX.put(ComunioConstants.REMO_MAX_PLAYERS_PER_TEAM, conf.getRemoMaxJugadoresEquipo());
		responseX.put(ComunioConstants.REMO_TRUPITAS, conf.getRemoTrupitas());
		responseX.put(ComunioConstants.STARTING_MONEY, conf.getDineroInicial());
		responseX.put(ComunioConstants.BONUS_POINTS, conf.getBonusPunto());
		responseX.put(ComunioConstants.MAX_PLAYERS, conf.getMaxJugadores());
		responseX.put(ComunioConstants.MAX_PLAYERS_EACH_TEAM, conf.getMaxJugadoresEquipo());
		responseX.put(ComunioConstants.NUM_COBRADORES_GENERAL, conf.getnTorpesGeneral());
		responseX.put(ComunioConstants.NUM_JORNADAS_QUE_FORMAN_UN_CICLO, conf.getnJornadasCiclo());
		responseX.put(ComunioConstants.NUM_TORPES_PAGADOS_POR_CICLO, conf.getMaxTorpesCiclo());
		
			
		
		return response;
	}
	
	private List<String> getList(String filters){
		 List<String> list = new ArrayList<String>();
			if(filters.equals(Constants.PLAYING_POSITION)) {
				for(int i=0; i<Constants.PLAYING_POSITION_LIST.length; i++)
					list.add(Constants.PLAYING_POSITION_LIST[i]);
			}else if(filters.equals(Constants.TEAMS)) {
				List<Team> equipos = getComunioDAO().getTeams();
				for(int i=0; i<equipos.size(); i++)
					list.add(equipos.get(i).getName());
			}else if(filters.equals(Constants.PARTICIPANTS)) {
				List<Participant> participantes = getComunioDAO().getGamersInformation();
				for(int i=0; i<participantes.size(); i++)
					list.add(participantes.get(i).getName());
			}else if(filters.equals(Constants.PARTICIPANTS_PLUS_COMPUTER)) {
				List<Participant> participantes = getComunioDAO().getGamersInformation();
				list.add(Constants.COMPUTER);
				for(int i=0; i<participantes.size(); i++)
					list.add(participantes.get(i).getName());
			}else if(filters.equals(Constants.PENALTIES)) {
				for(int i=0; i<Constants.PENALTY_TYPES.length; i++)
					list.add(Constants.PENALTY_TYPES[i]);
			}
			return list;
	 }
	
	private List<Score> getRoundInformation(Participant participant, String type){
		List<Score> list = new ArrayList<Score>();
		Score score = null;
		Round referenceRound = getNextRound();
		if(type.equals(Constants.ALL_ROUNDS)) {
			//jornadas con puntos + jornada siguiente (por tema de goles, publicado, primas...)
			referenceRound = getNextRound();
		}else if(type.equals(Constants.ALL_ROUNDS_RESTRICTED)){
			referenceRound = getCurrentRound();
		}
		List<Score> listAux = getComunioDAO().getRoundInformation(participant.getTableName());
		for(int i=0; i<listAux.size(); i++) {
			if(participant.getFirstRound().doubleValue() > listAux.get(i).getRound().doubleValue()) {
				continue;
			}
			if(participant.getLastRound().doubleValue() < listAux.get(i).getRound().doubleValue()) {
				break;
			}
			if(listAux.get(i).getRound().doubleValue() <= referenceRound.getValue().doubleValue()){
				list.add(listAux.get(i));
			}else{
				break;
			}
		}
		return list;
	}
	
	/*
	 * Función que devulve la jornada actual
	 */
	public Round getCurrentRound(){
		return getComunioDAO().getCurrentRound();
	}
	
	/*
	 * Función que devulve la jornada actual
	 */
	public Round getNextRound(){
		return getComunioDAO().getNextRound();
	}
	

}
