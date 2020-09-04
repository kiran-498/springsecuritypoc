package com.hcl.task.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.hcl.task.model.ActionType;
import com.hcl.task.model.Role;
import com.hcl.task.model.User;

@Component
public class InsertData {

	public List<Role> insertRolesData() {

		List<Role> list = new ArrayList<Role>();
		Role adminRole = new Role();
		adminRole.setName("admin");
		List<ActionType> adminactionList = new ArrayList<ActionType>();
		adminactionList.add(actionTypeWrite());
		adminactionList.add(actionTypeRead());
		adminRole.setActionType(adminactionList);
		list.add(adminRole);
		/////////////
		Role managerRole = new Role();
		managerRole.setName("manager");
		List<ActionType> manageractionList = new ArrayList<ActionType>();
		manageractionList.add(actionTypeWrite());
		manageractionList.add(actionTypeRead());
		managerRole.setActionType(manageractionList);
		list.add(managerRole);
		//////////////////////
		Role hrRole = new Role();
		hrRole.setName("hr");
		List<ActionType> hractionList = new ArrayList<ActionType>();
		hractionList.add(actionTypeWrite());
		hractionList.add(actionTypeRead());
		hrRole.setActionType(hractionList);
		list.add(hrRole);
		//////////////////////
		Role clearkRole = new Role();
		clearkRole.setName("cleark");
		List<ActionType> clearkactionList = new ArrayList<ActionType>();
		clearkactionList.add(actionTypeRead());
		clearkRole.setActionType(clearkactionList);
		list.add(clearkRole);
		return list;

	}

	private static ActionType actionTypeWrite() {
		ActionType write = new ActionType();
		write.setName("write");
		return write;
	}

	private static ActionType actionTypeRead() {
		ActionType read = new ActionType();
		read.setName("read");
		return read;
	}

	public List<User> insertUsersData() {

		List<User> list = new ArrayList<User>();
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("admin");
		Set<Role> adminRoleSet = new HashSet<Role>();
		Role adminRole = new Role();
		adminRole.setName("admin");
		adminRoleSet.add(adminRole);
		adminUser.setRoles(adminRoleSet);
		list.add(adminUser);
		/////////////

		User managerUser = new User();
		managerUser.setUsername("manager");
		managerUser.setPassword("manager");
		Set<Role> managerRoleSet = new HashSet<Role>();
		Role managerRole = new Role();
		managerRole.setName("manager");
		managerRoleSet.add(managerRole);
		managerUser.setRoles(managerRoleSet);
		list.add(managerUser);

		//////////////////////

		User hrUser = new User();
		hrUser.setUsername("hr");
		hrUser.setPassword("hr");
		Set<Role> hrRoleSet = new HashSet<Role>();
		Role hrRole = new Role();
		hrRole.setName("hr");
		hrRoleSet.add(hrRole);
		hrUser.setRoles(hrRoleSet);
		list.add(hrUser);

		//////////////////////

		User clearkUser = new User();
		clearkUser.setUsername("cleark");
		clearkUser.setPassword("cleark");
		Set<Role> clearkRoleSet = new HashSet<Role>();
		Role clearkRole = new Role();
		clearkRole.setName("cleark");
		clearkRoleSet.add(clearkRole);
		clearkUser.setRoles(clearkRoleSet);
		list.add(clearkUser);

		return list;
	}
}
