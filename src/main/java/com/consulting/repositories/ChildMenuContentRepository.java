package com.consulting.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.consulting.models.ChildMenuContent;

public interface ChildMenuContentRepository extends JpaRepository<ChildMenuContent, Integer>{

	Page<ChildMenuContent> findAllByOrderByChildMenuContentIdDesc(Pageable page);
	
	@Query(value="SELECT * FROM menu_child_content LIMIT 1", nativeQuery = true)
	List<ChildMenuContent> getFirstOneRows();
}
