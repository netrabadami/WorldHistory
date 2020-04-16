package com.codingdojo.javastack.springboot.worldhistory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.javastack.springboot.worldhistory.models.Countries;
import com.codingdojo.javastack.springboot.worldhistory.repositories.CountriesRepository;

@Service
public class CountriesService {
	
	private final CountriesRepository countryRepo;
	
	public CountriesService(CountriesRepository countryRepo) {
		this.countryRepo = countryRepo;
	}
	
	public Countries createCountry(Countries country) {
		return countryRepo.save(country);
	}
	
	public List<Countries> allCountries(){
		return countryRepo.findAll();
	}
	
	public Optional<Countries> getCountry(Long id) {
		return countryRepo.findById(id);
	}

	public Countries findOne(Long id) {
		Optional<Countries> optional = countryRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
}
