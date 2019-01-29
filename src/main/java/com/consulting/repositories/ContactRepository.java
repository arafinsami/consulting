package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	Page<Contact> findAllByOrderByContactIdDesc(Pageable page);
	
	/*@Query(value = "SELECT COUNT(*) FROM contact_us", nativeQuery = true)
	Contact getAllCounts();*/

}
