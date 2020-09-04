package com.hcl.task.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.task.model.Role;
import com.hcl.task.model.RoleUserPKKey;
import com.hcl.task.model.User;
import com.hcl.task.service.UpdateRolesService;
import com.hcl.task.utility.KeysUtility;
import com.hcl.task.utility.SpringException;

@Controller
public class UpdateRolesController {

	@Autowired
	private UpdateRolesService updateRolesService;

	@GetMapping(KeysUtility.ROOT_HANDLER)
	public String getUsers(HttpServletRequest request, Model model) {
		model.addAttribute(KeysUtility.USER_KEY, updateRolesService.getAllUsers());
		return KeysUtility.INDEX_VIEW;
	}

	@GetMapping(KeysUtility.EDIT_HANDLER)
	public String getUserById(@RequestParam(KeysUtility.ID_KEY) Long id, Model model) {

		User user = updateRolesService.getUserById(id);
		model.addAttribute(KeysUtility.USER_DATA_KEY, user);
		return KeysUtility.EDIT_VIEW;
	}

	@PostMapping(KeysUtility.ROLE_DELETE_HANDLER)
	public String deleteRole(@ModelAttribute RoleUserPKKey roleUser, Model model) {
		try {
			updateRolesService.deleteRole(roleUser);
		} catch (SpringException ex) {
			model.addAttribute(KeysUtility.ERROR_MESSAGE, ex.getExceptionMsg());
			return KeysUtility.ERROR;
		}

		return KeysUtility.REDIRECT;
	}

	@GetMapping(KeysUtility.GET_ROLES_HANDLER)
	public String getRoles(@RequestParam(KeysUtility.ID_KEY) Long id, Model model) {
		Set<Role> unassignedRoles = new HashSet<>();
		try {
			unassignedRoles = updateRolesService.getRoles(id);
		} catch (SpringException ex) {
			model.addAttribute(KeysUtility.ERROR_MESSAGE, ex.getExceptionMsg());
			return KeysUtility.ERROR;
		}
		model.addAttribute(KeysUtility.ROLES_KEY, unassignedRoles);
		model.addAttribute(KeysUtility.USER_ID_KEY, id);
		return KeysUtility.ADD_ROLE_VIEW;
	}

	@PostMapping(KeysUtility.ADD_ROLES_HANDLER)
	public String addRole(@ModelAttribute RoleUserPKKey data, Model model) {
		try {
			updateRolesService.addRole(data.getRoleId(), data.getUserId());
		} catch (SpringException ex) {
			model.addAttribute(KeysUtility.ERROR_MESSAGE, ex.getExceptionMsg());
			return KeysUtility.ERROR;
		}

		return KeysUtility.REDIRECT;
	}
}
