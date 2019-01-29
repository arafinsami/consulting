package com.consulting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.Slider;

@Repository
public interface SliderRepository extends JpaRepository<Slider, Integer>{

	Page<Slider> findAllByOrderBySliderIdDesc(Pageable page);
}
