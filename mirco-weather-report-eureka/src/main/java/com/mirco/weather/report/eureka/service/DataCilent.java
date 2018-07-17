package com.mirco.weather.report.eureka.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mirco.weather.report.eureka.vo.City;
import com.mirco.weather.report.eureka.vo.WeatherResponse;

@FeignClient(value="mirco-weather-zuul",fallback=DataClientFallback.class)
public interface DataCilent {
	
	@GetMapping(value="city/cities")
	List<City> listCity();

	
	@GetMapping(value="data/weather/cityName/{cityName}")
	WeatherResponse getWeatherByCityName(@PathVariable(value="cityName") String cityName);
	
}
