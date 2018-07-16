package com.micro.example.collection.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.micro.example.collection.vo.City;

@FeignClient(value="mirco-weather-zuul")
public interface CityClientService {
	
	@GetMapping(value="city/cities")
	List<City> cityList();

}
