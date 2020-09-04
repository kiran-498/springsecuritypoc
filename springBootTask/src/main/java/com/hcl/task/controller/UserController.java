package com.hcl.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.task.model.Role;
import com.hcl.task.model.User;
import com.hcl.task.service.UserService;
import com.hcl.task.utility.KeysUtility;

@RestController
@RequestMapping(KeysUtility.INSERT_HANDLER)
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(KeysUtility.ROLE_HANDLER)
	public String saveRole(@RequestBody Role role) {

		return userService.saveRole(role);
	}

	@PostMapping(KeysUtility.USER_HANDLER)
	public String saveUser(@RequestBody User user) {

		return userService.saveUser(user);
	}
	
	@PostMapping(KeysUtility.INSERT_DUMMY_DATA_HANDLER)
	public String insertDummyData() {

		 userService.insertDummyData();
		 return KeysUtility.SUCESS;
	}

}
