package com.rukiasoft.server.elpuntal.database;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.rukiasoft.server.elpuntal.classes.Configuration;
import com.rukiasoft.server.elpuntal.classes.Log;
import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.classes.Round;
import com.rukiasoft.server.elpuntal.classes.Score;
import com.rukiasoft.server.elpuntal.classes.Signing;




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
	
	public List<Log> getLogs();
}
