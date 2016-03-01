package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

	@Expose@SerializedName("name")
	private String name;
	@Expose@SerializedName("position")
	private String position;
	@Expose@SerializedName("team")
	private String team;
	@Expose@SerializedName("owner")
	private String owner;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
