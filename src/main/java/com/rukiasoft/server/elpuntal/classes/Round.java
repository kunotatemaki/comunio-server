package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Round {

	@Expose@SerializedName("label")
	private String label;
	@Expose@SerializedName("value")
	private Double value;
	@Expose@SerializedName("state")
	private Boolean state;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	
}
