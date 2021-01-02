package com.ruleta.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.models.Bet;
import com.ruleta.models.Ruleta;
import com.ruleta.repository.ruleta.RuletaRepository;

@RestController
@RequestMapping("/ruleta")
public class RuletaController {

	@Autowired
	private RuletaRepository ruletaRepository;

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Map<Long, Ruleta> findAll() {
		Map<Long, Ruleta> ruleta = ruletaRepository.findAll();
		return ruleta;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Ruleta findById(@PathVariable("id") Long id) {
		return ruletaRepository.find(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public Map<String, String> postRuleta() {
		ruletaRepository.save();
		Map<String, String> response = new HashMap<String, String>();
		response.put("id", String.valueOf(ruletaRepository.save()));
		return response;
	}

	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces =
	 * "application/json") public Map<String, String> deleteById(@PathVariable("id")
	 * Long id) { ruletaRepository.delete(id); Map<String, String> response = new
	 * HashMap<String, String>(); response.put("response", "OK"); return response; }
	 */

	@RequestMapping(value = "/open/{id}", method = RequestMethod.PATCH, produces = "application/json")
	public Ruleta openRuleta(@PathVariable("id") Long id) {
		Ruleta ruleta = ruletaRepository.find(id);
		if (ruleta != null) {
			if (!ruleta.isOpen() && ruleta.isNew()) {
				ruleta.setNew(false);
				ruleta.setOpen(true);
				ruletaRepository.update(ruleta);
				// return melo
			}
		}
		// return fallo
		return ruletaRepository.find(id);
	}

	@RequestMapping(value = "/close/{id}", method = RequestMethod.PATCH, produces = "application/json")
	public Ruleta closeRuleta(@PathVariable("id") Long id) {
		Ruleta ruleta = ruletaRepository.find(id);
		if (ruleta != null) {
			if (ruleta.isOpen()) {
				ruleta.setOpen(false);
				ruleta.setNumberWin((int) (Math.random() * 37));
				ruleta.setBlackIsWin(Math.random() < 0.5);
				ruletaRepository.update(ruleta);
			} else {
				// es una ruleta cerrada
			}
		} else {
			// no existe
		}

		return ruletaRepository.find(id);
	}

	@RequestMapping(value = "/bet", method = RequestMethod.PATCH, produces = "application/json")
	public Ruleta betOnRuleta(@RequestBody Bet betIn ) {
		Ruleta ruleta = ruletaRepository.find(betIn.getRuletaId());
		if (ruleta != null) {
			if (ruleta.isOpen()) {
				List<Object> bet= ruleta.getBet();
				bet.add(betIn);
				ruleta.setBet(bet);						
				ruletaRepository.update(ruleta);
			} else {
				// es una ruleta cerrada
			}
		} else {
			// no existe
		}

		return ruletaRepository.find( betIn.getRuletaId() );
	}
	
}
