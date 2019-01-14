/**
 * 
 */
package com.micro.weather.city.eureka.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micro.weather.city.eureka.dao.WeatherDao;
import com.micro.weather.city.eureka.domain.ResponseVO;
import com.micro.weather.city.eureka.service.WeatherDataCollectionService;
import com.micro.weather.city.eureka.service.WeatherDataService;
import com.micro.weather.city.eureka.vo.WeatherResponse;

/**
 * @author zeng
 */
@RestController
@RequestMapping("/weather")
public class WeatherDataController {

	
	@Autowired
	private WeatherDao weatherDao;
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	
	@RequestMapping(value = "/listAll" ,method = RequestMethod.GET)
	public List<ResponseVO> listAll() {
		return weatherDao.queryWeatherAll();
	}
	
	
	@RequestMapping(value = "/getDataByCityCode/{code}",method = RequestMethod.GET)
	public WeatherResponse getWeatherByCityName(@PathVariable(name="code") String code){
		if(StringUtils.isNotBlank(code)) {
			return	weatherDataService.queryWeatherDataByCityCode( code);
			 
		}
		return null;
	}
	
	
	
}
