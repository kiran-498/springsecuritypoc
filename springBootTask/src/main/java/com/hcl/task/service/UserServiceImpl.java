package com.hcl.task.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.task.config.InsertData;
import com.hcl.task.model.ActionType;
import com.hcl.task.model.Role;
import com.hcl.task.model.User;
import com.hcl.task.repository.ActionTypeRepository;
import com.hcl.task.repository.RoleRepository;
import com.hcl.task.repository.UserRepository;
import com.hcl.task.utility.KeysUtility;
import com.hcl.task.utility.SpringException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ActionTypeRepository actionTypeRepository;
	@Autowired
	private InsertData insertData;

	@Override
	public String saveRole(Role role) {
		List<ActionType> actionType = new ArrayList<ActionType>();
		for (ActionType single : role.getActionType()) {
			Optional<ActionType> type1 = actionTypeRepository.findByName(single.getName());
			if (type1 == null || !type1.isPresent()) {
				throw new SpringException(KeysUtility.ACTION_DETAILS_ERROR + single.getName());
			}
			actionType.add(type1.get());
		}

		role.setActionType(actionType);
		roleRepository.save(role);

		return KeysUtility.SUCESS;
	}

	@Override
	public String saveUser(User user) {
		String encrytedPassword = encrytePassword(user.getPassword());
		user.setPassword(encrytedPassword);
		Set<Role> role = new HashSet<Role>();
		for (Role single : user.getRoles()) {
			Role role2 = roleRepository.findByName(single.getName());
			if (role2 == null) {
				throw new SpringException(KeysUtility.ROLE_DETAILS_ERROR + single.getName());
			}
			role.add(role2);
		}
		user.setRoles(role);
		userRepository.save(user);

		return KeysUtility.SUCESS;
	}

	public static String encrytePassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	@Override
	public void insertDummyData() {
		List<Role> list = insertData.insertRolesData();
		for(Role role : list) {
			this.saveRole(role);
		}
		List<User> userList = insertData.insertUsersData();
		for(User user : userList) {
			this.saveUser(user);
		}
	}

}
