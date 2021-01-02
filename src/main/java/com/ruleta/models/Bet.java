package com.ruleta.models;

import java.io.Serializable;

public class Bet implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long userOwnerId;
	private long ruletaId;
	private int numberWin;
	
	public long getUserOwnerId() {
		return userOwnerId;
	}
	public void setUserOwnerId(long userOwnerId) {
		this.userOwnerId = userOwnerId;
	}
	public long getRuletaId() {
		return ruletaId;
	}
	public void setRuletaId(long ruletaId) {
		this.ruletaId = ruletaId;
	}
	public int getNumberWin() {
		return numberWin;
	}
	public void setNumberWin(int numberWin) {
		this.numberWin = numberWin;
	}
	public boolean isBlack() {
		return isBlack;
	}
	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private boolean isBlack;
	private int amount;

}
