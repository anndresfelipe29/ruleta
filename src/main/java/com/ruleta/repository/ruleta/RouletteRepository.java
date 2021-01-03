package com.ruleta.repository.ruleta;

import java.util.Map;

import com.ruleta.models.Roulette;


public interface RouletteRepository {
	
	
	void save(Roulette roulette);

	Roulette find(Long id);

	Map<Long, Roulette> findAll();

	void update(Roulette roulette);

	void delete(Long id);

	Long save();
	
	boolean exists(Long id);

}
