package com.codingdojo.javastack.springboot.worldhistory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javastack.springboot.worldhistory.models.Countries;

@Repository
public interface CountriesRepository extends CrudRepository<Countries, Long> {
	
	List<Countries> findAll();
}



