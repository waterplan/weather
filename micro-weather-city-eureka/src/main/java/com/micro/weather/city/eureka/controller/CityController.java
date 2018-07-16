package com.micro.weather.city.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.weather.city.eureka.service.CityDataService;
import com.micro.weather.city.eureka.vo.City;

@RestController
@RequestMapping(value="/cities")
public class CityController {

	@Autowired
	CityDataService cityDataService;
	
	@GetMapping
	public List<City> listCity() throws Exception{
		return cityDataService.listCity();
	}
	
	
	
}
