package com.ruleta.repository.ruleta;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.ruleta.models.Ruleta;

@Repository
public class RuletaRepositoryImpl implements RuletaRepository {

	private static final String KEY = "ruleta";
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, Ruleta> hashOperations;

	@Autowired
	public RuletaRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
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
		hashOperations.put(KEY, id, new Ruleta(id));
		return id;
	}

	@Override
	public void save(Ruleta ruleta) {
		hashOperations.put(KEY, ruleta.getId(), ruleta);

	}

	@Override
	public Ruleta find(Long id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, Ruleta> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(Ruleta ruleta) {
		hashOperations.put(KEY, ruleta.getId(), ruleta);
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
