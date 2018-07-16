package com.micro.example.collection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.example.collection.service.CityClientService;
import com.micro.example.collection.vo.City;

@RestController
public class CityController {

	@Autowired
	private CityClientService cityClientService;
	
	@GetMapping(value="/cities")
	public List<City> listCity(){
		return cityClientService.cityList();
	}
}
