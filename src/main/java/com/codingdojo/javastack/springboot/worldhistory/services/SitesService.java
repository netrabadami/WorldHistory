package com.codingdojo.javastack.springboot.worldhistory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.javastack.springboot.worldhistory.models.Sites;
import com.codingdojo.javastack.springboot.worldhistory.repositories.SitesRepository;

@Service
public class SitesService {
	
	private final SitesRepository siteRepo;
	
	public SitesService(SitesRepository siteRepo) {
		this.siteRepo = siteRepo;
	}
	
	public Sites createSite(Sites site) {
		return siteRepo.save(site);
	}
	
	public List<Sites> allSites(){
		return siteRepo.findAll();
	}
	
	public Optional<Sites> getSite(Long id) {
		return siteRepo.findById(id);
	}
	
	public Sites findOne(Long id) {
		Optional<Sites> optional = siteRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

}
