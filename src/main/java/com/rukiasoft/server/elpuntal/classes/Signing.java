package com.rukiasoft.server.elpuntal.classes;

public class Signing {

	private Integer Id;
	private String name;
	private String buyer;
	private String seller;
	private Integer prize;
	private Double round;
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
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Integer getPrize() {
		return prize;
	}
	public void setPrize(Integer prize) {
		this.prize = prize;
	}
	public Double getRound() {
		return round;
	}
	public void setRound(Double round) {
		this.round = round;
	}
	
	
}
