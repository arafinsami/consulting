package com.consulting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.models.ChooseUsList;

@Repository
public interface ChooseUsListRepository extends JpaRepository<ChooseUsList, Integer> {

}
