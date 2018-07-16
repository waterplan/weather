package com.mirco.weather.report.eureka.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mirco.weather.report.eureka.vo.City;

@FeignClient(value="mirco-weather-city-eureka")
public interface CityClient {

	@GetMapping(value="/cities")
	List<City> listCity();
}
