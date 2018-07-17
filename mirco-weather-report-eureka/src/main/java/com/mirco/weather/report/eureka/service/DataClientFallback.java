package com.mirco.weather.report.eureka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mirco.weather.report.eureka.vo.City;
import com.mirco.weather.report.eureka.vo.WeatherResponse;
@Component
public class DataClientFallback implements DataCilent{

	@Override
	public List<City> listCity() {
		// TODO Auto-generated method stubs
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101280301");
		city.setCityName("惠州");
		cityList.add(city);
		return cityList;
	}

	@Override
	public WeatherResponse getWeatherByCityName(String cityName) {
		// TODO Auto-generated method stub
		WeatherResponse result = new WeatherResponse();
		return result;
	}

}
