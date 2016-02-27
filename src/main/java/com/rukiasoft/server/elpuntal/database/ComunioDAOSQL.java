package com.rukiasoft.server.elpuntal.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;

import com.rukiasoft.server.elpuntal.classes.Participant;
import com.rukiasoft.server.elpuntal.utils.Constants;

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

}
