package com.codingdojo.javastack.springboot.worldhistory.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.javastack.springboot.worldhistory.models.Continents;
import com.codingdojo.javastack.springboot.worldhistory.models.Countries;
import com.codingdojo.javastack.springboot.worldhistory.models.Sites;
import com.codingdojo.javastack.springboot.worldhistory.models.User;
import com.codingdojo.javastack.springboot.worldhistory.repositories.CountriesRepository;
import com.codingdojo.javastack.springboot.worldhistory.repositories.SitesRepository;
import com.codingdojo.javastack.springboot.worldhistory.repositories.UserRepository;
import com.codingdojo.javastack.springboot.worldhistory.services.ContinentsService;
import com.codingdojo.javastack.springboot.worldhistory.services.CountriesService;
import com.codingdojo.javastack.springboot.worldhistory.services.SitesService;
import com.codingdojo.javastack.springboot.worldhistory.services.UserService;
import com.codingdojo.javastack.springboot.worldhistory.validators.UserValidator;

@Controller
public class UserController {
	
	private final UserRepository userRepo;
	private final UserService userService;
	private final UserValidator userValidator;
	private final ContinentsService continentService;
	private final CountriesService countryService;
	private final SitesService siteService;
	private final SitesRepository sitesRepo;
	private final CountriesRepository countriesrepo;
	
	public UserController(UserRepository userRepo,
							UserService userService,
							UserValidator userValidator,
							ContinentsService continentService,
							CountriesService countryService,
							SitesService siteService,
							SitesRepository sitesRepo,
							CountriesRepository countriesrepo) {
		this.userRepo = userRepo;
		this.userService = userService;
		this.userValidator = userValidator;
		this.continentService = continentService;
		this.countryService = countryService;
		this.siteService = siteService;
		this.countriesrepo=countriesrepo;
		this.sitesRepo = sitesRepo;;
		
	}
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("user") User user) {
		model.addAttribute("user", new User());
		return "home.jsp";
	}
	
	@GetMapping("/regLogin")
	public String regLogin(Model model) {
		model.addAttribute("user", new User());
		return "registerlogin.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,
							BindingResult result, Model model, 
							HttpSession session) {
//		userValidator.validate(user, result);
		if(result.hasErrors()) {
			System.out.println("errors:"+result);
        	return "registerlogin.jsp";
        } else {
        	System.out.println("test");
    		boolean isDuplicate = userService.duplicateUser(user.getEmail());
    		if(isDuplicate) {
    			model.addAttribute("error", "Email already in use! Please try again with a different email address!");
    			return "registerlogin.jsp";
    		}
    		User regUser = userService.registerUser(user);
    		session.setAttribute("userId", regUser.getId());
    		return "redirect:/Cities";
        }
	}

	@PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(userService.authenticateUser(email, password)) {
			
			User u = userRepo.findByEmail(email);
			session.setAttribute("userId", u.getId());
			if (u.getPriority() == 1) {
				return "redirect:/ad";
				
			} else {
				return "redirect:/";
			}
			

		} else {
			model.addAttribute("user", new User());
			model.addAttribute("error", "Invalid login");
			return "registerlogin.jsp";
		}
        
    }
	
	@GetMapping("/countries")
	public String country(Model model) {
		return "countries.jsp";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		return "admin.jsp";
	}
	
	@GetMapping("/ad")
	public String ad(Model model) {
		model.addAttribute("continents" ,new Continents());
		model.addAttribute("countries", new Countries());
		model.addAttribute("sites", new Sites());
		
		List<Continents> continentList = continentService.allContinents();
		model.addAttribute("continentList", continentList);
		
		List<Countries> countryList = countryService.allCountries();
		model.addAttribute("countryList", countryList);
		
		return "admin-new.jsp";
	}
	
	//	Create Continents
	@PostMapping("/createContinents")
	public String createContinents(@Valid @ModelAttribute("continents") Continents continents,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "admin-new.jsp";
		} else {
			continentService.createContinents(continents);
			return "redirect:/ad";
		}	
		
	}
	
	//	Create Countries
	@PostMapping(value="/createCountries")
	public String createCountries(@Valid @ModelAttribute("countries") Countries countries, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/createCountries";
		} else {
			countryService.createCountry(countries);
			return "redirect:/ad";
			
		}
	}
	
//	Create Sites
	@PostMapping(value="/createSite")
	public String createSite(@Valid @ModelAttribute("sites") Sites sites, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/createSite";
		} else {
			siteService.createSite(sites);
			return "redirect:/ad";
			
		}
	}
	
	
	  @GetMapping("/Cities/{country_id}")
	  public String city(Model model, @PathVariable(value = "country_id") Long id ) {
		  Countries country = countryService.findOne(id);
		  model.addAttribute("country", country);
		  return "Cities.jsp";
	  }
	
//Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//Home Page
	@GetMapping("/continent/{continent_name}")
	  public String countries(Model model, @PathVariable("continent_name") String name) {
		  List<Countries> countries = countriesrepo.findAll();
		  for(int i = countries.size() - 1; i > -1; i--) {
			  if(countries.get(i).getContinents().getContinent_name().equals(name) == false) {
				  countries.remove(i);
			  }
		  }
		  model.addAttribute("countries", countries);
		  return "home.jsp";
	  }
	
//Info Page
//	@GetMapping("/siteinfo/{country_id}/{site_id}")
	@GetMapping("/Cities/{country_id}/{site_id}")
	 public String info(Model model, @PathVariable("country_id") Long cid, @PathVariable("site_id") Long sid) {
		 Countries country = countryService.findOne(cid);
		 Sites site = siteService.findOne(sid);
		 for(int i = country.getSites().size() - 1; i > -1; i-- ) {
			 if(country.getSites().get(i).getCity_name().equals(site.getCity_name()) == false) {
				 country.getSites().remove(i);
			 }
		 }
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 
		 model.addAttribute("list", list);
		 model.addAttribute("country", country);
		 model.addAttribute("site", site);
		 System.out.println("COUNTRYYY: "+country+"City Name: "+country.getDescription());
		 System.out.println("COUNTRYYY: "+site+"site Name: "+site.getDescription());
		 return "Info.jsp";
	 }
	
//End of file
}
