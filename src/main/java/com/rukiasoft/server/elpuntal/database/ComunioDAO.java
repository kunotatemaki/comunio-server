package com.rukiasoft.server.elpuntal.database;

import java.util.ArrayList;
import java.util.List;

import com.rukiasoft.server.elpuntal.classes.Configuration;
import com.rukiasoft.server.elpuntal.classes.Log;
import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.classes.Round;
import com.rukiasoft.server.elpuntal.classes.Score;
import com.rukiasoft.server.elpuntal.classes.Signing;
import com.rukiasoft.server.elpuntal.classes.Team;




public interface ComunioDAO {

	public List<Participant> getParticipants();

	public Configuration getConf();
	
	public List<Round> getStoredRounds();
	
	public List<Round> getStoredPlusNextRounds();
	
	public Round getCurrentRound();
	
	public Round getNextRound();
	
	public List<Score> getRoundInformationByDate(String table, String date);
	
	public List<Score> getRoundInformation(String table);
	
	public List<Signing> getSigningInformation(String name);
	
	public List<Signing> getSigningInformationByGamer(String name, int type);
	
	public List<Log> getLogs();
	
	public List<Team> getTeams();
	
	public List<Participant> getGamersInformation();
	
	public ArrayList<String> checkStatusTeam(String nombre);
}
