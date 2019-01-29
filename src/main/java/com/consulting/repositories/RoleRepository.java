package com.consulting.repositories;

import com.consulting.models.*;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	@Query(value = "select r from Role r WHERE r.name='ROLE_ADMIN'")
    Set<Role> getAdminRole();
	
	@Query(value = "select r from Role r WHERE r.name='ROLE_USER'")
	Set<Role> getUserRole();
	
	Role findByName(String name);
}
