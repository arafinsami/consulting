package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.Gallery;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer>{

	Page<Gallery> findAllByOrderByGalleryIdDesc(Pageable page);
}
