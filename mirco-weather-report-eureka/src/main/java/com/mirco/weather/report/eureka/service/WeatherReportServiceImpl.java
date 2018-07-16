package com.mirco.weather.report.eureka.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirco.weather.report.eureka.vo.Weather;
import com.mirco.weather.report.eureka.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService{

	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityName(String name) {
		// TODO Auto-generated method stub
		Weather data = null;
		WeatherResponse weather = weatherDataService.getWeatherByCityName(name);
		data = weather.getData();
		return data;
	}

}
