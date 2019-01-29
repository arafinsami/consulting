package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.consulting.models.GalleryContent;

public interface GalleryContentRepository extends JpaRepository<GalleryContent, Integer>{

	Page<GalleryContent> findAllByOrderByGalleryContentIdDesc(Pageable page);
}
