package com.hcl.task.service;

import java.util.List;
import java.util.Set;

import com.hcl.task.model.Role;
import com.hcl.task.model.RoleUserPKKey;
import com.hcl.task.model.User;

public interface UpdateRolesService {

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public void deleteRole(RoleUserPKKey roleUser);

	public Set<Role> getRoles(Long id);

	public void addRole(Long roleId, Long userId);

}
