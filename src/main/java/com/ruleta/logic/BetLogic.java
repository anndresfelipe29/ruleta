package com.ruleta.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruleta.models.Bet;

@Component
public class BetLogic {

	@Autowired
	private UserLogic userLogic;

	public boolean reward(List<Bet> bets, boolean blackIsWin, int winNumber) {
		try {
			for (Bet bet : bets) {
				if ((bet.getblackIsWin() == blackIsWin) && (bet.getNumberWin()==-1)) { 
					userLogic.updateCash(bet.getUserOwnerId(), (bet.getAmount() * 1.8));

				}
				if (bet.getNumberWin() == winNumber) {
					userLogic.updateCash(bet.getUserOwnerId(), (bet.getAmount() * 5));
				}
			}
			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
