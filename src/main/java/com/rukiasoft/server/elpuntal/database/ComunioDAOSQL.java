package com.rukiasoft.server.elpuntal.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;

import com.rukiasoft.server.elpuntal.classes.Configuration;
import com.rukiasoft.server.elpuntal.classes.Log;
import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.classes.Player;
import com.rukiasoft.server.elpuntal.classes.Round;
import com.rukiasoft.server.elpuntal.classes.Score;
import com.rukiasoft.server.elpuntal.classes.Signing;
import com.rukiasoft.server.elpuntal.classes.Team;
import com.rukiasoft.server.elpuntal.services.ComunioMethods;
import com.rukiasoft.server.elpuntal.utils.Constants;
import com.rukiasoft.server.elpuntal.utils.Tools;




public class ComunioDAOSQL implements ComunioDAO{

	private JdbcTemplate jdbc;
	
	public ComunioDAOSQL() {
		super();
		ApplicationContext ctx = (ApplicationContext)ContextLoader.getCurrentWebApplicationContext();
		jdbc = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		
		
	}

	public List<Participant> getParticipants() {
		List<Participant> list = new ArrayList<>();
		
		//obtengo los nombres de los jugadores
		String sql = "SELECT * FROM " + Constants.GAMERS_TABLE;
		list = jdbc.query(sql, new BeanPropertyRowMapper<Participant>(Participant.class));
		return list;
	}

	@Override
	public Configuration getConf() {
		String error = "";
		String sql = "";
		Integer valor = null;
		Configuration conf = new Configuration();
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.BONUS_GOAL + "';";
		error = "Error leyendo valor de configuracion: " + Constants.BONUS_GOAL;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setGoalBonus(valor);
	
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.BONUS_GOALKEEPER + "';";
		error = "Error leyendo valor de configuracion: " + Constants.BONUS_GOALKEEPER;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setGoalkeeperBonus(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.BONUS_LAST_IN_ROUND + "';";
		error = "Error leyendo valor de configuracion: " + Constants.BONUS_LAST_IN_ROUND;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setRoundBonus(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.BONUS_LAST_IN_CLASSIFICATION + "';";
		error = "Error leyendo valor de configuracion: " + Constants.BONUS_LAST_IN_CLASSIFICATION;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setGeneralBonus(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.REMO_MAX_PLAYERS + "';";
		error = "Error leyendo valor de configuracion: " + Constants.REMO_MAX_PLAYERS;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setMaxPlayersPenalty(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.REMO_MAX_PLAYERS_PER_TEAM + "';";
		error = "Error leyendo valor de configuracion: " + Constants.REMO_MAX_PLAYERS_PER_TEAM;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setMaxPlayersTeamPenalty(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.REMO_TRUPITAS + "';";
		error = "Error leyendo valor de configuracion: " + Constants.REMO_TRUPITAS;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setTrupitaPenalty(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.BONUS_POINTS + "';";
		error = "Error leyendo valor de configuracion: " + Constants.BONUS_POINTS;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setPointBonus(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.STARTING_MONEY + "';";
		error = "Error leyendo valor de configuracion: " + Constants.STARTING_MONEY;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setStartingMoney(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.MAX_PLAYERS + "';";
		error = "Error leyendo valor de configuracion: " + Constants.MAX_PLAYERS;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setMaxPlayers(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.MAX_PLAYERS_EACH_TEAM + "';";
		error = "Error leyendo valor de configuracion: " + Constants.MAX_PLAYERS_EACH_TEAM;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setMaxPlayersTeam(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.NUM_COBRADORES_GENERAL + "';";
		error = "Error leyendo valor de configuracion: " + Constants.NUM_COBRADORES_GENERAL;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setNumGeneralBonus(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.NUM_TORPES_PAGADOS_POR_CICLO + "';";
		error = "Error leyendo valor de configuracion: " + Constants.NUM_TORPES_PAGADOS_POR_CICLO;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setMaxBonusCycle(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.NUM_ROUNDS_CYCLE + "';";
		error = "Error leyendo valor de configuracion: " + Constants.NUM_ROUNDS_CYCLE;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setNumRoundCycle(valor);
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.STARTING_ROUND + "';";
		error = "Error leyendo valor de configuracion: " + Constants.STARTING_ROUND;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setInitialRound(valor.doubleValue());
		
		sql ="SELECT " + Constants.FIELD_VALUE + " from " + Constants.CONF_TABLE 
				+ " WHERE " + Constants.FIELD_OPTION + " = '" + Constants.FINAL_ROUND + "';";
		error = "Error leyendo valor de configuracion: " + Constants.FINAL_ROUND;
		valor = jdbc.queryForObject(sql, Integer.class);
		conf.setFinalRound(valor.doubleValue());
		
		
		return conf;
	}
	
public List<Round> getStoredRounds(){
		
		List<Round> list = null;
		String error = "Error leyendo las Rounds almacenadas en la base de datos";
		String sql = "SELECT * FROM " + Constants.ROUNDS_TABLE 
				+ " WHERE " + Constants.FIELD_CONF_TABLE_STATE + " = true ORDER BY " + 
				Constants.FIELD_CONF_TABLE_VALUED + " ASC;";
		
		list= jdbc.query(sql, new BeanPropertyRowMapper<Round>(Round.class));
		
		return list;
	}
	
	public List<Round> getStoredPlusNextRounds(){
		
		List<Round> list = null;
		String error = "Error leyendo las Rounds almacenadas en la base de datos";
		String sql = "SELECT * FROM " + Constants.ROUNDS_TABLE 
				+ " ORDER BY " + Constants.FIELD_CONF_TABLE_VALUED + " ASC;";
		
		list= jdbc.query(sql, new BeanPropertyRowMapper<Round>(Round.class));
		Tools mTools = new Tools();
		if(list != null && list.size() == 0) {
			Round Round = new Round();
			Round.setValue(ComunioMethods.getConf().getInitialRound());
			Round.setLabel(mTools.getRoundLabelFromValue(Round.getValue()));
			list.add(Round);
			return list;
		}
		
		Boolean cortar = false;
		for(int i=0; i<list.size(); i++) {
			if(cortar) {
				while(i < list.size())
					list.remove(i);
				continue;
			}
			if(list.get(i).getState())
				continue;
			else
				cortar = true;
		}
		
		if(!cortar) {
			Round Round = new Round();
			Round.setValue(mTools.getParteEntera(list.get(list.size()-1).getValue() + 1).doubleValue());
			Round.setLabel(mTools.getRoundLabelFromValue(Round.getValue()));
			list.add(Round);
		}
		return list;
	}
	
	public Round getCurrentRound(){
		List<Round> list = getStoredRounds();
		if(list.size() > 0)
			return list.get(list.size()-1);
		else {
			Round Round = new Round();
			Round.setValue(0.0);
			Tools mTools = new Tools();
			Round.setLabel(mTools.getRoundLabelFromValue(Round.getValue()));
			return Round;
		}
	}
	
	public Round getNextRound(){
		List<Round> list = getStoredPlusNextRounds();
		return list.get(list.size() - 1);
	}

	public List<Score> getRoundInformationByDate(String table, String date) {
		List<Score> list = null;
		String sql = "SELECT * FROM " + table;
		if(date != null)
			sql += " WHERE " + Constants.FIELD_DATE + " > '" + date + "'";
		sql += " ORDER BY " + Constants.FIELD_ROUND + " ASC;";
		list= jdbc.query(sql, new BeanPropertyRowMapper<Score>(Score.class));
		
		return list;
	}
	
	public List<Score> getRoundInformation(String table){
		return getRoundInformationByDate(table, null);
	}
	
	public List<Signing> getSigningInformation(String name){
		
		List<Signing> list = null;
		
		String sql = "SELECT * FROM " + Constants.SIGNING_TABLE;
		if(!name.equals(Constants.ALL_SIGNINGS)) {
			sql += " WHERE " + Constants.FIELD_NAME + " = '" + name + "' ORDER BY "
					+ Constants.FIELD_DATE + " DESC;";
		}else
			sql +=  " ORDER BY " + Constants.FIELD_DATE + " ASC;";
		
		list= jdbc.query(sql, new BeanPropertyRowMapper<Signing>(Signing.class));
		
		return list;
	}

	public List<Signing> getSigningInformationByGamer(String name, int type){
		
		List<Signing> list = null;
		
		String sql = "SELECT * FROM " + Constants.SIGNING_TABLE;
		String field = "";
		if(type == Constants.SELLER) {
			field = Constants.FIELD_SELLER;
		}else if(type == Constants.BUYER) {
			field = Constants.FIELD_BUYER;
		}
		sql +=  " WHERE " + field + " = '" + name + "' AND " 
				+ Constants.FIELD_PRIZE + " > 0 ORDER BY "
				+ Constants.FIELD_DATE + " DESC;";
		
		list= jdbc.query(sql, new BeanPropertyRowMapper<Signing>(Signing.class));
		
		return list;
	}

	public List<Log> getLogs(){
		List<Log> list = null;
		
		String sql = "SELECT * FROM " + Constants.LOG_TABLE + " ORDER BY " 
				+ Constants.FIELD_DATE + " DESC;";
	
		list = jdbc.query(sql, new BeanPropertyRowMapper<Log>(Log.class));
			
		return list;
	}
	
	public List<Team> getTeams(){
		List<Team> list = null;
		
		//obtengo los nombres de los jugadores
		String sql = "SELECT * FROM " + Constants.TEAMS_TABLE + "";
		list = jdbc.query(sql, new BeanPropertyRowMapper<Team>(Team.class));
		
		return list;
	}
	
	public List<Participant> getGamersInformation(){
		List<Participant> list = null;
		
		//obtengo los nombres de los jugadores
		String sql = "SELECT * FROM " + Constants.GAMERS_TABLE + " ORDER BY " + Constants.FIELD_NAME + " ASC;";
		list = jdbc.query(sql, new BeanPropertyRowMapper<Participant>(Participant.class));
		
		return list;
	}
	
	public ArrayList<String> checkStatusTeam(String nombre){
		ArrayList<String> sanciones = new ArrayList<String>();
		List<Player> list = null;
		String error = "";
		String sql ="SELECT * FROM " + Constants.PLAYERS_TABLE + " WHERE " + Constants.FIELD_OWNER 
				+ " = '" + nombre + "' ORDER BY " + Constants.FIELD_TEAM + " ASC;";
		
		error = "Error database leyendo posibles sanciones - max players";
		list = jdbc.query(sql, new BeanPropertyRowMapper<Player>(Player.class));
		
		if(list.size() > ComunioMethods.getConf().getMaxPlayers()){
			sanciones.add(Constants.PENALTY_TYPES[0] + ": " + list.size());
		}
		String equipo = "";
		Integer contador = 0;
		for(Player player : list) {
			if(player.getTeam().equals(equipo)) {
				contador++;
				if(contador > ComunioMethods.getConf().getMaxPlayersTeam()) {
					sanciones.add(Constants.PENALTY_TYPES[1] + ": " + equipo);
					break;
				}						
			}else {
				equipo = player.getTeam();
				contador = 1;
			}
		}
		
		
		return sanciones;
	}
	
}
