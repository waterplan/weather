package com.mirco.weather.report.eureka.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mirco.weather.report.eureka.vo.WeatherResponse;


@FeignClient(value="mirco-weather-data-eureka")
public interface WeatherDataService {
	
	@GetMapping("/weather/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);

}
