package org.micor.weather.basic.controller;

import org.micor.weather.basic.service.WeatherDataService;
import org.micor.weather.basic.vo.ResponseVO;
import org.micor.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	WeatherDataService weatherDataService;
	
	
	@RequestMapping(value="/cityId/{cityId}",method=RequestMethod.GET)
	public ResponseVO<WeatherResponse> getWeatherByCityId(@PathVariable("cityId") String cityId){
		ResponseVO result=new ResponseVO<>();
		WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);
		result.setData(weatherResponse);
		return result;
	}
	
	
	@RequestMapping(value="/cityName/{cityName}",method=RequestMethod.GET)
	public ResponseVO<WeatherResponse> getWeatherByCityName(@PathVariable("cityName") String cityName){
		ResponseVO result=new ResponseVO<>();
		WeatherResponse weatherResponse = weatherDataService.getDataByCityName(cityName);
		result.setData(weatherResponse);
		return result;
	}
}
