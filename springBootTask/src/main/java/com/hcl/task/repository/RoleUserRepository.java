package com.hcl.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.task.model.RoleUser;
import com.hcl.task.model.RoleUserPKKey;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, RoleUserPKKey>{
	
	

}
