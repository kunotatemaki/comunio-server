package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rukiasoft.server.elpuntal.services.ComunioMethods;
import com.rukiasoft.server.elpuntal.utils.Constants;

public class Score{
	
	@Expose@SerializedName("id")
	private Integer Id = null;
	@Expose@SerializedName("round")
	private Double round = null;
	@Expose@SerializedName("round_score")
	private Integer roundScore = null;
	@Expose@SerializedName("round_score_assigned")
	private Integer roundScoreAssigned = 0;
	@Expose@SerializedName("round_position")
	private Integer roundPosition = null;
	@Expose@SerializedName("general_score")
	private Integer generalScore = null;
	@Expose@SerializedName("general_score_assigned")
	private Integer generalScoreAssigned = 0;
	@Expose@SerializedName("general_position")
	private Integer generalPosition = null;
	
	@Expose@SerializedName("published")
	private Boolean published = false;
	@Expose@SerializedName("goals")
	private Integer goals = 0;
	@Expose@SerializedName("goalkeeper")
	private Boolean goalkeeper = false;
	@Expose@SerializedName("team_penalty")
	private Boolean teamPenalty = false;
	@Expose@SerializedName("player_penalty")
	private Boolean playerPenalty = false;
	@Expose@SerializedName("trupita_penalty")
	private Boolean trupitaPenalty = false;
	@Expose@SerializedName("round_bonus")
	private Boolean roundBonus = false;
	@Expose@SerializedName("general_bonus")
	private Integer generalBonus = 0;
	@Expose@SerializedName("special_bonus")
	private Integer specialBonus = 0;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Double getRound() {
		return round;
	}
	public void setRound(Double round) {
		this.round = round;
	}
	public Integer getRoundScore() {
		return roundScore;
	}
	public void setRoundScore(Integer roundScore) {
		this.roundScore = roundScore;
	}
	public Integer getRoundPosition() {
		return roundPosition;
	}
	public void setRoundPosition(Integer roundPosition) {
		this.roundPosition = roundPosition;
	}
	public Integer getGeneralScore() {
		return generalScore;
	}
	public void setGeneralScore(Integer generalScore) {
		this.generalScore = generalScore;
	}
	public Integer getGeneralPosition() {
		return generalPosition;
	}
	public void setGeneralPosition(Integer generalPosition) {
		this.generalPosition = generalPosition;
	}
	public Boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}
	public Boolean getGoalkeeper() {
		return goalkeeper;
	}
	public void setGoalkeeper(Boolean goalkeeper) {
		this.goalkeeper = goalkeeper;
	}
	public Boolean getTeamPenalty() {
		return teamPenalty;
	}
	public void setTeamPenalty(Boolean teamPenalty) {
		this.teamPenalty = teamPenalty;
	}
	public Boolean getPlayerPenalty() {
		return playerPenalty;
	}
	public void setPlayerPenalty(Boolean playerPenalty) {
		this.playerPenalty = playerPenalty;
	}
	public Boolean getTrupitaPenalty() {
		return trupitaPenalty;
	}
	public void setTrupitaPenalty(Boolean trupitaPenalty) {
		this.trupitaPenalty = trupitaPenalty;
	}
	public Boolean getRoundBonus() {
		return roundBonus;
	}
	public void setRoundBonus(Boolean roundBonus) {
		this.roundBonus = roundBonus;
	}
	
	public Integer getGeneralBonus() {
		return generalBonus;
	}
	public void setGeneralBonus(Integer generalBonus) {
		this.generalBonus = generalBonus;
	}
	public Integer getSpecialBonus() {
		return specialBonus;
	}
	public void setSpecialBonus(Integer specialBonus) {
		this.specialBonus = specialBonus;
	}
	public Integer getRoundScoreAssigned() {
		return roundScoreAssigned;
	}
	public void setRoundScoreAssigned(Integer roundScoreAssigned) {
		this.roundScoreAssigned = roundScoreAssigned;
	}
	public Integer getGeneralScoreAssigned() {
		return generalScoreAssigned;
	}
	public void setGeneralScoreAssigned(Integer generalScoreAssigned) {
		this.generalScoreAssigned = generalScoreAssigned;
	}
	
}
