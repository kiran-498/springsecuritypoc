package com.hcl.task.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.hcl.task.model.Role;
import com.hcl.task.model.RoleUserPKKey;
import com.hcl.task.model.User;
import com.hcl.task.repository.RoleRepository;
import com.hcl.task.repository.RoleUserRepository;
import com.hcl.task.repository.UserRepository;
import com.hcl.task.utility.KeysUtility;
import com.hcl.task.utility.SpringException;

@Service
public class UpdateRolesServiceImpl implements UpdateRolesService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleUserRepository roleUserRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<User> getAllUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		return user;
	}

	@Override
	public void deleteRole(RoleUserPKKey roleUser) {
		chechWriteAction();
		Optional<User> optionalUser = userRepository.findById(roleUser.getUserId());
		if (optionalUser.get().getRoles().size() <= 1) {
			throw new SpringException(KeysUtility.ROLES_COUNT_ERROR);
		}
		roleUserRepository.deleteById(roleUser);

	}

	@Override
	public Set<Role> getRoles(Long id) {
		chechWriteAction();
		Optional<User> user = userRepository.findById(id);
		List<Role> roles = roleRepository.findAll();
		Set<Role> unassignedRoles = new HashSet<Role>();
		roles.stream().forEach(one -> {
			if (!user.get().getRoles().stream().anyMatch(single -> single.getName().equalsIgnoreCase(one.getName()))) {
				unassignedRoles.add(one);
			}

		});
		if (unassignedRoles == null || unassignedRoles.isEmpty()) {
			throw new SpringException(KeysUtility.ALL_ROLES_COUNT_ERROR);
		}

		return unassignedRoles;
	}

	private void chechWriteAction() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		Optional<User> userOptional = userRepository.findById(user.getId());
		;
		if (!userOptional.get().getRoles().stream().anyMatch(one->one.getActionType().stream().anyMatch(type->type.getName().equalsIgnoreCase(KeysUtility.WRITE_ROLE_KEY)))) {
			throw new SpringException(KeysUtility.WRITE_ACTION_ERROR);
		}
	}

	@Override
	public void addRole(Long roleId, Long userId) {
		chechWriteAction();
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		Optional<Role> optionalRole = roleRepository.findById(roleId);
		user.getRoles().add(optionalRole.get());
		userRepository.save(user);

	}

}
