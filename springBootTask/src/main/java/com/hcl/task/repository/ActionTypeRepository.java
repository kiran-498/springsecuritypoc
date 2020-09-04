package com.hcl.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.task.model.ActionType;
import java.lang.String;
import java.util.Optional;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionType, Long>{
	
       Optional<ActionType> findByName(String name);
}
