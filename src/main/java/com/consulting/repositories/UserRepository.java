package com.consulting.repositories;

import com.consulting.models.*;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUsername(String username);
    
    Page<User> findAllByOrderByIdDesc(Pageable page);
    
    @Query(value = "SELECT * FROM user", nativeQuery = true)
	List<User> findAllByUsernames(List<String> listOfUsernames);
}
