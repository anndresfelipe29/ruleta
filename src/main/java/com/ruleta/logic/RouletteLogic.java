package com.ruleta.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruleta.models.Bet;
import com.ruleta.models.Roulette;
import com.ruleta.repository.ruleta.RouletteRepository;

@Component
public class RouletteLogic {

	// @Autowired
	public RouletteLogic() {

	}

	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	private UserLogic userLogic;
	@Autowired
	private BetLogic betLogic;

	public Map<Long, Roulette> findAll() {
		return rouletteRepository.findAll();
	}

	public Roulette findById(Long id) {
		return rouletteRepository.find(id);
	}

	public Map<String, String> save() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("id", String.valueOf(rouletteRepository.save()));
		return response;
	}

	public Roulette openRuleta(Roulette roulette) {
		if (!roulette.isOpen() && roulette.isNew()) {
			roulette.setNew(false);
			roulette.setOpen(true);
			rouletteRepository.update(roulette);
			return rouletteRepository.find(roulette.getId());
		} else {

			return null;
		}

	}

	public boolean closeRuleta(Roulette roulette) {
		try {
			if (roulette.isOpen()) {
				roulette.setOpen(false);
				roulette.setNumberWin((int) (Math.random() * 37));				
				roulette.setBlackIsWin(!(roulette.getNumberWin()%2==0));
				rouletteRepository.update(roulette);
				betLogic.reward(roulette.getBet(), roulette.isBlackIsWin(), roulette.getNumberWin());
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}
	

	public boolean betOnRuletaForNumber(Roulette roulette, Long userId,int numberWin, double cash) {	
		try {
			if (roulette.isOpen()&& userLogic.verifyCash(userId, cash) && cash<10000 &&(0<=numberWin)&&(numberWin<=36)) {
				userLogic.updateCash(userId, -cash);
				List<Bet> bet = roulette.getBet();
				bet.add(new Bet( userId, roulette.getId(), numberWin, cash));
				roulette.setBet(bet);
				rouletteRepository.update(roulette);
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
		}
					
	}
	
	public boolean betOnRuletaForColor(Roulette roulette, Long userId,boolean color, double cash) {			
		if (roulette.isOpen()&& userLogic.verifyCash(userId, cash) && cash<10000) {
			userLogic.updateCash(userId, -cash);
			List<Bet> bet = roulette.getBet();
			bet.add(new Bet( userId, roulette.getId(), color, cash));
			roulette.setBet(bet);
			rouletteRepository.update(roulette);
			return true;
		} else {
			return false;
		}		
}
	

}
