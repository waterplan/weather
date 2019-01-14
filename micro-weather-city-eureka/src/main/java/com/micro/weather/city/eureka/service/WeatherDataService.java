/**
 * 
 */
package com.micro.weather.city.eureka.service;

import com.micro.weather.city.eureka.domain.ResponseVO;
import com.micro.weather.city.eureka.vo.WeatherResponse;

/**
 * @author zeng
 */
public interface WeatherDataService {

	WeatherResponse queryWeatherDataByCityCode(String cityCode);
	
	ResponseVO queryWeatherDataByCityName(String cityName);
	
	
	
	
}
