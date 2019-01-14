/**
 * 
 */
package com.micro.weather.city.eureka.task;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.micro.weather.city.eureka.domain.City;
import com.micro.weather.city.eureka.service.CityDataService;
import com.micro.weather.city.eureka.service.WeatherDataService;

/**
 * @author zeng
 */

@Component
public class WeatherSaveTask {

	@Autowired
	private CityDataService cityDataService;
	@Autowired
	private WeatherDataService weatherDataService;
 
	@Scheduled(cron = "0 0/2 * * * ? ")
	private void syncWeatherSaveTask() {
		try {
			System.out.println(" into task");
			List<City> listCity = cityDataService.listCity();
			for (City city : listCity) {
				String cityCode = city.getCityCode();
				if(!StringUtils.isEmpty(cityCode)) {
					weatherDataService.queryWeatherDataByCityCode(cityCode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
