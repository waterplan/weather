package com.micro.weather.city.eureka.service;

import java.util.List;

import com.micro.weather.city.eureka.vo.City;

public interface CityDataService {

	
	List<City> listCity() throws Exception;
}
