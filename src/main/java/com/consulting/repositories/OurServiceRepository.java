package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.OurService;


@Repository
public interface OurServiceRepository extends JpaRepository<OurService, Integer>{
	
	Page<OurService> findAllByOrderByOurServiceIdDesc(Pageable page);

}
