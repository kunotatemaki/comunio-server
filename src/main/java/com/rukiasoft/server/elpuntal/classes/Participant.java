package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant{
	
	private Integer Id;
	@Expose@SerializedName("name")
	private String nombre;
	@Expose@SerializedName("login")
	private String login;
	@Expose@SerializedName("table_name")
	private String tabla;
	@Expose@SerializedName("first_round")
	private Double j_inicial;
	@Expose@SerializedName("last_round")
	private Double j_final;
	@Expose@SerializedName("starting_points")
	private Integer puntos_inicio;
	@Expose@SerializedName("starting_bonus")
	private Integer prima_inicial;
	public Integer getId() {
		return Id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTabla() {
		return tabla;
	}
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	public Double getJ_inicial() {
		return j_inicial;
	}
	public void setJ_inicial(Double j_inicial) {
		this.j_inicial = j_inicial;
	}
	public Double getJ_final() {
		return j_final;
	}
	public void setJ_final(Double j_final) {
		this.j_final = j_final;
	}
	public Integer getPuntos_inicio() {
		return puntos_inicio;
	}
	public void setPuntos_inicio(Integer puntos_inicio) {
		this.puntos_inicio = puntos_inicio;
	}
	public Integer getPrima_inicial() {
		return prima_inicial;
	}
	public void setPrima_inicial(Integer prima_inicial) {
		this.prima_inicial = prima_inicial;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	
}
