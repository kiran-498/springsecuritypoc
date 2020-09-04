package com.hcl.task.service;


import com.hcl.task.model.Role;
import com.hcl.task.model.User;

public interface UserService {

	public String saveRole(Role role);
	public String saveUser(User user);
	public void insertDummyData();
}
