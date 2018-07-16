package com.mirco.weather.report.eureka.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirco.weather.report.eureka.vo.Weather;
import com.mirco.weather.report.eureka.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService{

	
	@Autowired
	private DataCilent dataCilent;
	
	@Override
	public WeatherResponse getDataByCityName(String name) {
		// TODO Auto-generated method stub
		WeatherResponse weather = dataCilent.getWeatherByCityName(name);
		return weather;
	}

}
