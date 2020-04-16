package com.codingdojo.javastack.springboot.worldhistory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codingdojo.javastack.springboot.worldhistory.models.Continents;
import com.codingdojo.javastack.springboot.worldhistory.repositories.ContinentsRepository;

@Service
public class ContinentsService {
	
	private final ContinentsRepository continentRepo;
	
	public ContinentsService(ContinentsRepository continentRepo) {
		this.continentRepo = continentRepo;
	}


	public Continents createContinents(Continents continents) {
		return continentRepo.save(continents);
	}
	
	public List<Continents> allContinents(){
		return continentRepo.findAll();
	}
	
	public Optional<Continents> getContinent(Long id) {
		return continentRepo.findById(id);
	}
}
