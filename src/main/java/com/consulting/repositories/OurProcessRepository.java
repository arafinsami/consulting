package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.OurProcess;

@Repository
public interface OurProcessRepository extends JpaRepository<OurProcess, Integer> {

	Page<OurProcess> findAllByOrderByOurProcessIdDesc(Pageable page);

}
