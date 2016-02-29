package com.rukiasoft.server.elpuntal.utils;

public class Constants {

	//tables
	public static final String GAMERS_TABLE = "participants";
	public static final String CONF_TABLE = "conf";
	public static final String ROUNDS_TABLE = "rounds";
	public static final String SIGNING_TABLE = "signings";
	public static final String LOG_TABLE = "log";
	public static final String TEAMS_TABLE = "teams";
	
	//fields json
	public static final String FIELD_PARTICIPANTS = "participants";
	public static final String FIELD_SCORES = "scores";
	public static final String FIELD_SIGNINGS = "signings";
	public static final String FIELD_LOGS = "logs";
	public static final String FIELD_COMPUTER = "computer";
	public static final String FIELD_TEAMS = "teams";
	
	
	//fields tables
	public static final String FIELD_CONF_TABLE_STATE = "state";
	public static final String FIELD_CONF_TABLE_VALUED = "value";
	public static final String FIELD_DATE = "date";
	public static final String FIELD_ROUND = "round";
	public static final String FIELD_NAME = "name";
	
	
	public static final Integer NO_BONUS = 0;
    public static final Integer GET_BONUS_CODE = 1;	
    public static final Integer NO_BONUS_BY_REPETITION = 2;
    
    public static final String ALL_SIGNINGS = "all_signings";
   
    public static final String COMPUTER = "Computer";
	public static final String STARTING_ROUND = "starting_round";
	public static final String FINAL_ROUND = "final_round";
	public static final String CURRENT_ROUND = "current_round";
	public static final String NEXT_ROUND = "next_round";
	public static final String BONUS_GOAL = "goal_bonus";
	public static final String BONUS_GOALKEEPER = "goalkeeper_bonus";
	public static final String BONUS_LAST_IN_ROUND = "bonus_last_in_round";
	public static final String BONUS_LAST_IN_CLASSIFICATION = "bonus_last_in_classification";
	public static final String REMO_MAX_PLAYERS = "max_players_penalty";
	public static final String REMO_MAX_PLAYERS_PER_TEAM = "max_players_team_penalty";
	public static final String REMO_TRUPITAS = "trupitas_penalty";
	public static final String BONUS_POINTS = "bonus_point";
	public static final String STARTING_MONEY = "starting_money";
	public static final String PLAYING_POSITION = "position";
	public static final String[] PLAYING_POSITION_LIST = {"portero","defensa","medio","delantero"};
	public static final String TEAMS = "teams";
	public static final String PARTICIPANTS = "participants";
	public static final String PARTICIPANTS_PLUS_COMPUTER = "participants_plus_computer";
	public static final String PENALTIES = "penalties";
	public static final String[] PENALTY_TYPES = {"Máximo número de Jugadores","Máximo de jugadores por equipo","Trúpitas", "Prima"};
	
	
	
	public static final String MAX_PLAYERS = "max_players";
	public static final String MAX_PLAYERS_EACH_TEAM = "max_players_team";
	
	public static final String NUM_COBRADORES_GENERAL = "num_cobradores_general";
	//se pueden cobrar 3 primas máximo en 5 jornadas
	public static final String NUM_TORPES_PAGADOS_POR_CICLO = "max_torpes_por_ciclo";
	public static final String NUM_ROUNDS_CYCLE = "num_rounds_cycle";
	
	public static final String ALL_ROUNDS = "all_rounds";
	public static final String ALL_ROUNDS_RESTRICTED = "all_rounds_restricted";
    
}

