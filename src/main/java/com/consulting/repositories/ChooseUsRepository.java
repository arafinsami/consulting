package com.consulting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.ChooseUs;

@Repository
public interface ChooseUsRepository extends JpaRepository<ChooseUs, Integer> {

}
