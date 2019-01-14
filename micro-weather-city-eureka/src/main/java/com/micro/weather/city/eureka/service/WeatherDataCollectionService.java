/**
 * 
 */
package com.micro.weather.city.eureka.service;

import com.micro.weather.city.eureka.vo.WeatherResponse;

/**
 * @author zeng
 */
public interface WeatherDataCollectionService {
	
    void syncDateByCityName(String CityName);
    
    WeatherResponse QueryDateByCityCode(String cityCode);

}
