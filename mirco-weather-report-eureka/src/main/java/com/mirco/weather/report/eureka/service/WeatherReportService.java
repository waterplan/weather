package com.mirco.weather.report.eureka.service;

import com.mirco.weather.report.eureka.vo.Weather;
import com.mirco.weather.report.eureka.vo.WeatherResponse;

public interface WeatherReportService {
	
	WeatherResponse getDataByCityName(String name);

}
