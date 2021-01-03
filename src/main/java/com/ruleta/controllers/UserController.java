package com.ruleta.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruleta.logic.UserLogic;
import com.ruleta.models.User;
import com.ruleta.repository.user.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserLogic userLogic; 
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public Map<String, String> save() {
		userRepository.save(new User(1, "Jack", "Smith"));
		userRepository.save(new User(2, "Adam", "Johnson"));
		userRepository.save(new User(3, "Kim", "Smith"));
		userRepository.save(new User(4, "David", "Williams"));
		userRepository.save(new User(5, "Peter", "Davis"));
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", "OK");
		return response;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Map<Long, User> findAll() {		
		return userLogic.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public User findById(@PathVariable("id") Long id) {
		return userLogic.findById(id);
	}

	/*@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public Map<String, String> postCustomer(@RequestBody User user) {
		userRepository.save(new User(user.getId(), user.getFirstName(), user.getLastName()));
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", "OK");
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public Map<String, String> deleteById(@PathVariable("id") Long id) {
		userRepository.delete(id);
		Map<String, String> response = new HashMap<String, String>();
		response.put("response", "OK");
		return response;
	}*/

	@RequestMapping(value = "", method = RequestMethod.PATCH, produces = "application/json")
	public User updateCustomer(@RequestBody User userIn) {		
		return userLogic.update(userIn);
	}

}
