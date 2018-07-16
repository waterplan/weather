package com.mirco.weather.report.eureka.service;

import com.mirco.weather.report.eureka.vo.Weather;

public interface WeatherReportService {
	
	Weather getDataByCityName(String name);

}
