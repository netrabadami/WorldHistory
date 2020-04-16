package com.codingdojo.javastack.springboot.worldhistory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javastack.springboot.worldhistory.models.Continents;


@Repository
public interface ContinentsRepository extends CrudRepository<Continents, Long> {
	
	List<Continents> findAll();
}


