package com.codingdojo.javastack.springboot.worldhistory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javastack.springboot.worldhistory.models.Sites;
@Repository
public interface SitesRepository extends CrudRepository<Sites, Long> {
	
	List<Sites> findAll();
}


