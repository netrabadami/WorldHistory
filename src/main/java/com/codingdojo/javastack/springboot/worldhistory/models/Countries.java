package com.codingdojo.javastack.springboot.worldhistory.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="countries")
public class Countries {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Size(min = 2, max = 50)
    private String country_name;
	
	@Size(min = 5, max = 5000)
    private String description;
	
	@OneToMany(mappedBy="countries", fetch = FetchType.LAZY)
    private List<Sites> sites;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    
    private Continents continents;
	
    
    public Countries(){
    
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCountry_name() {
		return country_name;
	}


	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Sites> getSites() {
		return sites;
	}


	public void setSites(List<Sites> sites) {
		this.sites = sites;
	}


	public Continents getContinents() {
		return continents;
	}


	public void setContinents(Continents continents) {
		this.continents = continents;
	}
    
    
}
