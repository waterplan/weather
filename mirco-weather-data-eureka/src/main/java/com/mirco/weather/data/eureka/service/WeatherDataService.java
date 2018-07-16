package com.mirco.weather.data.eureka.service;

import com.mirco.weather.data.eureka.vo.WeatherResponse;

public interface WeatherDataService {

	
	WeatherResponse getDataByCityId(String cityId);
	
	WeatherResponse getDataByCityName(String cityName);
	
}
