package com.ruleta.logic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruleta.models.User;
import com.ruleta.repository.user.UserRepository;

@Component
public class UserLogic {
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<Long, User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		return userRepository.find(id);
	}
	
	public User update( User userIn) {
		User user = userRepository.find(userIn.getId());
		user.setFirstName(userIn.getFirstName().toUpperCase());
		user.setLastName(userIn.getLastName().toUpperCase());
		userRepository.update(user);
		return userRepository.find(userIn.getId());
	}
	
	
	public User updateCash( Long id, double d) {
		User user = userRepository.find(id);
		user.setCash(user.getCash()+d);
		userRepository.update(user);
		return userRepository.find(id);
	}
	
	
	public boolean verifyCash(Long id, double cash) {
		User user= userRepository.find(id);
		return (user.getCash()>cash)?true:false;
	}
	
	
	
}
