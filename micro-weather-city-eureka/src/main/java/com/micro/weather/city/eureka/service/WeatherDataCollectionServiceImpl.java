/**
 * 
 */
package com.micro.weather.city.eureka.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.weather.city.eureka.dao.WeatherDao;
import com.micro.weather.city.eureka.domain.ResponseVO;
import com.micro.weather.city.eureka.vo.WeatherResponse;

/**
 * @author zeng
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

	
	private static final String WEATHER_URI = "http://t.weather.sojson.com/api/weather/city/";

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WeatherDao weatherDao;
	
	
	
	@Override
	public void syncDateByCityName(String CityName) {
		String uri = WEATHER_URI+"city="+CityName;
		saveWeatherData(uri);
	}
	
	
	private ResponseVO saveWeatherData(String uri) {
		String strBody = null;
		// 调用服务接口来获取
 		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

 		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}
 		// 数据写入缓存
 		ResponseVO responseVO = new ResponseVO();
		responseVO.setWeatherData(strBody);
		weatherDao.insert(responseVO);
		return responseVO;
	}


	
	@Override
	public WeatherResponse QueryDateByCityCode(String cityCode) {
		String uri = WEATHER_URI+cityCode;
		ResponseVO weatherData = saveWeatherData(uri);
		ObjectMapper mapper = new ObjectMapper();
		try {
			WeatherResponse weather = mapper.readValue(weatherData.getWeatherData(), WeatherResponse.class);
			return weather;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
