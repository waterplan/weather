package com.micro.weather.city.eureka.service;

import java.util.List;

import com.micro.weather.city.eureka.domain.City;

public interface CityDataService {

	
	List<City> listCity() throws Exception;
	
	void insertCity(City city);
}
