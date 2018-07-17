package com.micro.example.collection.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.example.collection.service.CityClientService;
import com.micro.example.collection.vo.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CityController {

	@Autowired
	private CityClientService cityClientService;
	
	@GetMapping(value="/cities")
	@HystrixCommand(fallbackMethod="defaultcities")
	public List<City> listCity(){
		return cityClientService.cityList();
	}
	
	public List<City> defaultcities(){
		List<City> result = new ArrayList<>();
		return result;
	}
}
