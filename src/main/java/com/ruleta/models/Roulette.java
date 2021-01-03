package com.ruleta.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Roulette implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private boolean isOpen;
	private int numberWin;
	private boolean blackIsWin;
	private boolean isNew;
	private List<Bet> bets;

	protected Roulette() {
	}

	public Roulette(long id) {
		this.id = id;
		this.isNew = true;
		this.numberWin = -1;
		this.bets= new ArrayList<Bet>();

	}

	public Roulette(long id, boolean isOpen, int numberWin, boolean blackIsWin) {
		this.id = id;
		this.isOpen = isOpen;
		this.numberWin = numberWin;
		this.blackIsWin = blackIsWin;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public int getNumberWin() {
		return numberWin;
	}

	public void setNumberWin(int numberWin) {
		this.numberWin = numberWin;
	}

	public boolean isBlackIsWin() {
		return blackIsWin;
	}

	public void setBlackIsWin(boolean blackIsWin) {
		this.blackIsWin = blackIsWin;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public List<Bet> getBet() {
		return bets;
	}

	public void setBet(List<Bet> bets) {
		this.bets = bets;
	}
}
