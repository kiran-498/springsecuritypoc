package com.hcl.task.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="role_user")
@IdClass(RoleUserPKKey.class)
public class RoleUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="user_id")
	private Long userId;
	@Id
	@Column(name="role_id")
	private Long roleId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
	
	
}
