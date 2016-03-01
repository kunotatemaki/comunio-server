package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant{
	
	@Expose@SerializedName("id")
	private Integer Id;
	@Expose@SerializedName("name")
	private String name;
	@Expose@SerializedName("login")
	private String login;
	@Expose@SerializedName("table_name")
	private String tableName;
	@Expose@SerializedName("first_round")
	private Double firstRound;
	@Expose@SerializedName("last_round")
	private Double lastRound;
	@Expose@SerializedName("starting_points")
	private Integer startingPoints;
	@Expose@SerializedName("starting_bonus")
	private Integer startingBonus;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Double getFirstRound() {
		return firstRound;
	}
	public void setFirstRound(Double firstRound) {
		this.firstRound = firstRound;
	}
	public Double getLastRound() {
		return lastRound;
	}
	public void setLastRound(Double lastRound) {
		this.lastRound = lastRound;
	}
	public Integer getStartingPoints() {
		return startingPoints;
	}
	public void setStartingPoints(Integer startingPoints) {
		this.startingPoints = startingPoints;
	}
	public Integer getStartingBonus() {
		return startingBonus;
	}
	public void setStartingBonus(Integer startingBonus) {
		this.startingBonus = startingBonus;
	}
}
