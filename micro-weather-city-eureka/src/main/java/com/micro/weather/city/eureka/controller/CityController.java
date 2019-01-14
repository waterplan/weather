package com.micro.weather.city.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.weather.city.eureka.domain.City;
import com.micro.weather.city.eureka.service.CityDataService;

@RestController
@RequestMapping(value="/cities")
public class CityController {
	
	

	@Autowired
	CityDataService cityDataService;
	
	@GetMapping(name = "/all")
	public List<City> listCity() throws Exception{
		return cityDataService.listCity();
	}	
	
	
}
