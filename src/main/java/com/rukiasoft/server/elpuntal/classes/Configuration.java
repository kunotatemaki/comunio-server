package com.rukiasoft.server.elpuntal.classes;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configuration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Expose@SerializedName("goal_bonus")
	private Integer goalBonus;
	@Expose@SerializedName("goalkeeper_bonus")
	private Integer goalkeeperBonus;
	@Expose@SerializedName("round_bonus")
	private Integer roundBonus;
	@Expose@SerializedName("general_bonus")
	private Integer generalBonus;
	@Expose@SerializedName("max_players_penalty")
	private Integer maxPlayersPenalty;
	@Expose@SerializedName("max_players_team_penalty")
	private Integer maxPlayersTeamPenalty;
	@Expose@SerializedName("point_bonus")
	private Integer pointBonus;
	@Expose@SerializedName("trupita")
	private Integer trupitaPenalty;
	@Expose@SerializedName("starting_money")
	private Integer startingMoney;
	@Expose@SerializedName("max_players")
	private Integer maxPlayers;
	@Expose@SerializedName("max_players_team")
	private Integer maxPlayersTeam;
	@Expose@SerializedName("num_general_bonus")
	private Integer numGeneralBonus;
	@Expose@SerializedName("num_bonus_cycle")
	private Integer maxBonusCycle;
	@Expose@SerializedName("num_rounds_cycle")
	private Integer numRoundCycle;
	@Expose@SerializedName("initial_round")
	private Double initialRound;
	@Expose@SerializedName("final_round")
	private Double finalRound;
	
	public Integer getGoalBonus() {
		return goalBonus;
	}
	public void setGoalBonus(Integer goalBonus) {
		this.goalBonus = goalBonus;
	}
	public Integer getGoalkeeperBonus() {
		return goalkeeperBonus;
	}
	public void setGoalkeeperBonus(Integer goalkeeperBonus) {
		this.goalkeeperBonus = goalkeeperBonus;
	}
	public Integer getRoundBonus() {
		return roundBonus;
	}
	public void setRoundBonus(Integer roundBonus) {
		this.roundBonus = roundBonus;
	}
	public Integer getGeneralBonus() {
		return generalBonus;
	}
	public void setGeneralBonus(Integer generalBonus) {
		this.generalBonus = generalBonus;
	}
	public Integer getMaxPlayersPenalty() {
		return maxPlayersPenalty;
	}
	public void setMaxPlayersPenalty(Integer maxPlayersPenalty) {
		this.maxPlayersPenalty = maxPlayersPenalty;
	}
	public Integer getMaxPlayersTeamPenalty() {
		return maxPlayersTeamPenalty;
	}
	public void setMaxPlayersTeamPenalty(Integer maxTeamsPenalty) {
		this.maxPlayersTeamPenalty = maxTeamsPenalty;
	}
	public Integer getPointBonus() {
		return pointBonus;
	}
	public void setPointBonus(Integer pointBonus) {
		this.pointBonus = pointBonus;
	}
	public Integer getTrupitaPenalty() {
		return trupitaPenalty;
	}
	public void setTrupitaPenalty(Integer trupitaPenalty) {
		this.trupitaPenalty = trupitaPenalty;
	}
	public Integer getStartingMoney() {
		return startingMoney;
	}
	public void setStartingMoney(Integer startingMoney) {
		this.startingMoney = startingMoney;
	}
	public Integer getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public Integer getMaxPlayersTeam() {
		return maxPlayersTeam;
	}
	public void setMaxPlayersTeam(Integer maxPlayersTeam) {
		this.maxPlayersTeam = maxPlayersTeam;
	}
	public Integer getNumGeneralBonus() {
		return numGeneralBonus;
	}
	public void setNumGeneralBonus(Integer numGeneralBonus) {
		this.numGeneralBonus = numGeneralBonus;
	}
	public Integer getMaxBonusCycle() {
		return maxBonusCycle;
	}
	public void setMaxBonusCycle(Integer maxBonusCycle) {
		this.maxBonusCycle = maxBonusCycle;
	}
	public Integer getNumRoundCycle() {
		return numRoundCycle;
	}
	public void setNumRoundCycle(Integer numRoundCycle) {
		this.numRoundCycle = numRoundCycle;
	}
	public Double getInitialRound() {
		return initialRound;
	}
	public void setInitialRound(Double initialRound) {
		this.initialRound = initialRound;
	}
	public Double getFinalRound() {
		return finalRound;
	}
	public void setFinalRound(Double finalRound) {
		this.finalRound = finalRound;
	}
	
	
}
