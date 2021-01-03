package com.ruleta.repository.ruleta;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ruleta.models.Roulette;

@Repository
public class RouletteRepositoryImpl implements RouletteRepository {

	private static final String KEY = "ruleta";
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, Roulette> hashOperations;

	@Autowired
	public RouletteRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	public Long generateId() {
		return hashOperations.size(KEY);
	}

	public Long save() {
		long id = generateId();
		hashOperations.put(KEY, id, new Roulette(id));
		return id;
	}

	@Override
	public void save(Roulette roulette) {
		hashOperations.put(KEY, roulette.getId(), roulette);

	}

	@Override
	public Roulette find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, Roulette> findAll() {
		
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(Roulette roulette) {
		hashOperations.put(KEY, roulette.getId(), roulette);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);
	}

	@Override
	public boolean exists(Long id) {
		return hashOperations.hasKey(KEY, id);
	}

}
