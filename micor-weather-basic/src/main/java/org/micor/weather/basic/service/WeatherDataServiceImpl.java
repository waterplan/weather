package org.micor.weather.basic.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.micor.weather.basic.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	
	private final Logger LOG=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RedisTemplate redisTemplate;

	private final String WEATHER_URI="https://www.sojson.com/open/api/weather/json.shtml?";
	
    private final long TIME_OUT=1800L; //1h
	
	@Autowired
	private RestTemplate  restTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		// TODO Auto-generated method stub
		LOG.info("getDataByCityId method  param :{}",cityId);
		String uri=WEATHER_URI+"cityId="+cityId;
		
		return doGetWeahter(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// TODO Auto-generated method stub
		LOG.info("getDataByCityName method param :{}",cityName);
		String uri=WEATHER_URI+"city="+cityName;
		return doGetWeahter(uri);
	}
	
	private WeatherResponse doGetWeahter(String uri) {
		LOG.info("doGetWeahter  method  param  uri:{}",uri);
		String key=uri;
		ObjectMapper mapper=new ObjectMapper();
		WeatherResponse response=null;
		String strBody=null;
		if(redisTemplate.hasKey(key)) {
			LOG.info("redis has data ");
			strBody=(String) redisTemplate.opsForValue().get(key);
		}
		else {
			LOG.info("redis no has data ");
			ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
			if(respString.getStatusCodeValue()==200) {
				strBody=respString.getBody();
			}
			redisTemplate.opsForValue().set(key, strBody,TIME_OUT,TimeUnit.SECONDS);
		}
		
		try {
			 response = mapper.readValue(strBody.getBytes(), WeatherResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error(" doGetWeather method :{}",e);
		}
		
		return response;
	}

}
