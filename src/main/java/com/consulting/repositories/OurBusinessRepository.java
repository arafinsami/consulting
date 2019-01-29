package com.consulting.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.consulting.models.*;

@Repository
public interface OurBusinessRepository extends JpaRepository<OurBusiness, Integer>{
	
	@Query(value= "SELECT * FROM our_business  LIMIT 1",nativeQuery=true)
	List<OurBusiness> getFirstOne();
	
	Page<OurBusiness> findAllByOrderByOurBusinessIdDesc(Pageable page);

}
