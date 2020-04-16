package com.codingdojo.javastack.springboot.worldhistory.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="continents")
public class Continents {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 50,message="Continent name must be atleast 2 characters")
    private String continent_name;
	
	@OneToMany(mappedBy="continents", fetch = FetchType.LAZY)
    private List<Countries> countries;
    
    
	public Continents() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getContinent_name() {
		return continent_name;
	}


	public void setContinent_name(String continent_name) {
		this.continent_name = continent_name;
	}


	public List<Countries> getCountries() {
		return countries;
	}


	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}
	
	
}
