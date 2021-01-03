package com.ruleta.models;

import java.io.Serializable;

public class Bet implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userOwnerId;
	private long rouletteId;
	private int numberWin;
	private boolean blackIsWin;
	private double amount;
	
	public Bet(long userOwnerId,long ruletaId,int numberWin, double amount ) {
		this.userOwnerId= userOwnerId;
		this.rouletteId= ruletaId;
		this.numberWin=numberWin;
		this.amount=amount;
	}
	public Bet(long userOwnerId,long ruletaId,boolean blackIsWin, double amount ) {
		this.userOwnerId= userOwnerId;
		this.rouletteId= ruletaId;
		this.blackIsWin=blackIsWin;
		this.amount=amount;
	}
	public Bet() {}

	public long getUserOwnerId() {
		return userOwnerId;
	}

	public void setUserOwnerId(long userOwnerId) {
		this.userOwnerId = userOwnerId;
	}

	public long getRuletaId() {
		return rouletteId;
	}

	public void setRuletaId(long ruletaId) {
		this.rouletteId = ruletaId;
	}

	public int getNumberWin() {
		return numberWin;
	}

	public void setNumberWin(int numberWin) {
		this.numberWin = numberWin;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean getblackIsWin() {
		return blackIsWin;
	}

	public void setblackIsWin(boolean blackIsWin) {
		this.blackIsWin = blackIsWin;
	}

}
