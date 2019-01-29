package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.OurTeam;

@Repository
public interface OurTeamRepository extends JpaRepository<OurTeam, Integer>{
	
	Page<OurTeam> findAllByOrderByTeamIdDesc(Pageable page);

}
