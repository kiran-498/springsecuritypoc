package com.hcl.task.utility;

public class KeysUtility {

	public static final String ERROR = "error";
	public static final String ERROR_MESSAGE ="errorMessage";
	public static final String SUCESS="SUCESS";
	
	/******  Views ********/
	public static final String INDEX_VIEW="index";
	public static final String EDIT_VIEW="edit";
	public static final String ADD_ROLE_VIEW="addRole";
	public static final String REDIRECT="redirect:/";
	
	/******  Request Handlers ********/
	public static final String ROOT_HANDLER="/";
	public static final String EDIT_HANDLER="/edit";
	public static final String ROLE_DELETE_HANDLER="/roleDelete";
	public static final String GET_ROLES_HANDLER="/getRoles";
	public static final String ADD_ROLES_HANDLER="/addRole";
	public static final String INSERT_HANDLER ="/insert";
	public static final String ROLE_HANDLER="/role";
	public static final String USER_HANDLER="/user";
	public static final String INSERT_DUMMY_DATA_HANDLER="/insertDummyData";
	
	/******  Keys ********/
	public static final String USER_KEY="users";
	public static final String ID_KEY="id";
	public static final String USER_DATA_KEY="userData";
	public static final String ROLES_KEY="roles";
	public static final String USER_ID_KEY="userId";
	public static final String WRITE_ROLE_KEY="write";
	
	/******  Error messages ********/
	public static final String ROLES_COUNT_ERROR="User should have atleast one role";
	public static final String ALL_ROLES_COUNT_ERROR="User have all roles";
	public static final String WRITE_ACTION_ERROR="User don't have write option";
	public static final String ACTION_DETAILS_ERROR="Action details not found with ";
	public static final String ROLE_DETAILS_ERROR="Role Details not found with ";
}
