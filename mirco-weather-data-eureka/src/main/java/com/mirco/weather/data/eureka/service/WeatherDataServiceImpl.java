package com.mirco.weather.data.eureka.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirco.weather.data.eureka.vo.WeatherResponse;
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	private static final String WEATHER_URI = "https://www.sojson.com/open/api/weather/json.shtml?";
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		String uri = WEATHER_URI+"cityId="+cityId;
		return null;
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) throws JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		String uri = WEATHER_URI+"city="+cityName;
		return doGetWeahter(uri);
	}
	
	public WeatherResponse doGetWeahter(String uri) throws JsonParseException, JsonMappingException, IOException {
		String key = uri;
		ObjectMapper mapper = new ObjectMapper();
		String strBody = null;
		WeatherResponse result = null;
		if(redisTemplate.hasKey(key)) {
			LOG.info("redis has data");
			strBody = (String) redisTemplate.opsForValue().get(key);
			  result = mapper.readValue(strBody.getBytes(), WeatherResponse.class);
		}
		else {
			LOG.info("redis has data");
			new RuntimeException(" Don't has data!");
		}
		
		return result;
	}

}
