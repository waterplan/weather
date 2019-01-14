/**
 * 
 */
package com.micro.weather.city.eureka.service;

import java.io.IOException;
import java.util.Objects;

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
public class WeatherDataServiceImpl implements WeatherDataService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WeatherDao weatherDao;
	
	private static final String WEATHER_URI = "http://t.weather.sojson.com/api/weather/city/";

	@Override
	public WeatherResponse queryWeatherDataByCityCode(String cityCode) {
		String url = WEATHER_URI + cityCode;
        ResponseVO responseVO = weatherDao.getOne(cityCode);
        if(Objects.isNull(responseVO)) {
        	responseVO  = new ResponseVO();
        	responseVO.setCityCode(cityCode);
    		saveWeatherData(url, responseVO);
        }
		ObjectMapper mapper = new ObjectMapper();
		try {
			WeatherResponse response = mapper.readValue(responseVO.getWeatherData(), WeatherResponse.class);
			return response;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	
	
	/**
	 * @param url
	 * @param responseVO
	 */
	private void saveWeatherData(String url, ResponseVO responseVO) {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
		String stringBody = null;
		if(responseEntity.getStatusCodeValue() == 200) {
			stringBody = responseEntity.getBody();
		}
		responseVO.setRequestUrl(url);
		responseVO.setWeatherData(stringBody);
		weatherDao.insert(responseVO);
	}



	@Override
	public ResponseVO queryWeatherDataByCityName(String cityName) {
		return null;
	}

}
