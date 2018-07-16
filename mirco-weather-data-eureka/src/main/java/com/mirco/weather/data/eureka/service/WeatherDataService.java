package com.mirco.weather.data.eureka.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mirco.weather.data.eureka.vo.WeatherResponse;

public interface WeatherDataService {

	
	WeatherResponse getDataByCityId(String cityId);
	
	WeatherResponse getDataByCityName(String cityName) throws JsonParseException, JsonMappingException, IOException;
	
}
