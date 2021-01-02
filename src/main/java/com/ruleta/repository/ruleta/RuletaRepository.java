package com.ruleta.repository.ruleta;

import java.util.Map;

import com.ruleta.models.Ruleta;

public interface RuletaRepository {
	
	
	void save(Ruleta ruleta);

	Ruleta find(Long id);

	Map<Long, Ruleta> findAll();

	void update(Ruleta ruleta);

	void delete(Long id);

	Long save();
	
	boolean exists(Long id);

}
