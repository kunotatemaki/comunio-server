package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

	@Expose@SerializedName("id")
	private Integer Id;
	@Expose@SerializedName("name")
	private String name;
	@Expose@SerializedName("shield")
	private String shield;

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
	public String getShield() {
		return shield;
	}
	public void setShield(String shield) {
		this.shield = shield;
	}
	
	
}
