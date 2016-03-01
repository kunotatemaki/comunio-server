package com.rukiasoft.server.elpuntal.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rukiasoft.server.elpuntal.services.ComunioMethods;
import com.rukiasoft.server.elpuntal.utils.Constants;

public class Score{
	
	@Expose@SerializedName("id")
	private Integer Id = null;
	@Expose@SerializedName("table_name")
	private String tableName = null;
	@Expose@SerializedName("name")
	private String name = null;
	@Expose@SerializedName("round")
	private Double round = null;
	@Expose@SerializedName("round_score")
	private Integer roundScore = null;
	@Expose@SerializedName("round_position")
	private Integer roundPosition = null;
	@Expose@SerializedName("general_score")
	private Integer generalScore = null;
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
	
	@Expose@SerializedName("round_bonus_money")
	private Integer roundBonusMoney = 0;
	@Expose@SerializedName("general_bonus_money")
	private Integer generalBonusMoney = 0;
	@Expose@SerializedName("goals_money")
	private Integer goalsMoney = 0;
	@Expose@SerializedName("goalkeeper_money")
	private Integer goalkeeperMoney = 0;
	@Expose@SerializedName("team_penalty_money")
	private Integer teamPenaltyMoney = 0;
	@Expose@SerializedName("player_penalty_money")
	private Integer playerPenaltyMoney = 0;
	@Expose@SerializedName("trupita_penalty_money")
	private Integer trupitaPenaltyMoney = 0;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		setGoalsMoney(goals);
	}
	public Boolean getGoalkeeper() {
		return goalkeeper;
	}
	public void setGoalkeeper(Boolean goalkeeper) {
		this.goalkeeper = goalkeeper;
		setGoalkeeperMoney(goalkeeper);
	}
	public Boolean getTeamPenalty() {
		return teamPenalty;
	}
	public void setTeamPenalty(Boolean teamPenalty) {
		this.teamPenalty = teamPenalty;
		setTeamPenaltyMoney(teamPenalty);
	}
	public Boolean getPlayerPenalty() {
		return playerPenalty;
	}
	public void setPlayerPenalty(Boolean playerPenalty) {
		this.playerPenalty = playerPenalty;
		setPlayerPenaltyMoney(playerPenalty);
	}
	public Boolean getTrupitaPenalty() {
		return trupitaPenalty;
	}
	public void setTrupitaPenalty(Boolean trupitaPenalty) {
		this.trupitaPenalty = trupitaPenalty;
		setTrupitaPenaltyMoney(trupitaPenalty);
	}
	public Boolean getRoundBonus() {
		return roundBonus;
	}
	public void setRoundBonus(Boolean roundBonus) {
		this.roundBonus = roundBonus;
		setRoundBonusMoney(roundBonus);
	}
	public Integer getRoundBonusMoney() {
		return roundBonusMoney;
	}
	public void setRoundBonusMoney(Boolean roundBonus) {
		this.roundBonusMoney = this.roundBonus? ComunioMethods.getConf().getRoundBonus() : 0;
	}
	public Integer getGoalsMoney() {
		return goalsMoney;
	}
	public void setGoalsMoney(Integer goals) {
		this.goalsMoney = goals * ComunioMethods.getConf().getGoalBonus();
	}
	public Integer getGoalkeeperMoney() {
		return goalkeeperMoney;
	}
	public void setGoalkeeperMoney(Boolean goalkeep) {
		this.goalkeeperMoney = this.goalkeeper? ComunioMethods.getConf().getGoalkeeperBonus() : 0;
	}
	public Integer getTeamPenaltyMoney() {
		return teamPenaltyMoney;
	}
	public void setTeamPenaltyMoney(Boolean teamPenalty) {
		this.teamPenaltyMoney = this.teamPenalty? ComunioMethods.getConf().getMaxPlayersTeamPenalty() : 0;
	}
	public Integer getPlayerPenaltyMoney() {
		return playerPenaltyMoney;
	}
	public void setPlayerPenaltyMoney(Boolean playerPenaltyMoney) {
		this.playerPenaltyMoney = this.playerPenalty? ComunioMethods.getConf().getMaxPlayersPenalty() : 0;
	}
	public Integer getTrupitaPenaltyMoney() {
		return trupitaPenaltyMoney;
	}
	public void setTrupitaPenaltyMoney(Boolean trupitaPenalty) {
		this.trupitaPenaltyMoney = this.trupitaPenalty? ComunioMethods.getConf().getTrupitaPenalty() : 0;
	}
	
	
	public Integer getGeneralBonus() {
		return generalBonus;
	}
	public void setGeneralBonus(Integer generalBonus) {
		this.generalBonus = generalBonus;
		setGeneralBonusMoney();
	}
	public Integer getGeneralBonusMoney() {
		return generalBonusMoney;
	}
	public void setGeneralBonusMoney() {
		this.generalBonusMoney = this.generalBonus.equals(Constants.GET_BONUS_CODE)? ComunioMethods.getConf().getGeneralBonus() : 0;	
	}

	
	
	
}
