package com.ruleta.repository.user;

import java.util.Map;
import com.ruleta.models.User;

public interface UserRepository {

	void save(User user);

	User find(Long id);

	Map<Long, User> findAll();

	void update(User user);

	void delete(Long id);

}
