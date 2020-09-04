package com.hcl.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.task.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String input);

}
