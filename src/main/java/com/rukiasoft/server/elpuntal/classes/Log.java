package com.rukiasoft.server.elpuntal.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private Integer Id;
	private String operation;
	private Date date;
	private String sDate;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
		setsDate(date);
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(Date date) {
		if(date != null){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			sDate = df.format(this.date);
		}
	}
	
	
}
