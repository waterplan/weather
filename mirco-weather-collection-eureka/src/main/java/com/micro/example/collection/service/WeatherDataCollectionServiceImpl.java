package com.micro.example.collection.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService{
	
	private static final String WEATHER_URI = "https://www.sojson.com/open/api/weather/json.shtml?";

	private  final long TIME_OUT = 1800L; // 1800s
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void syncDateByCityName(String CityName) {
		// TODO Auto-generated method stub
		String uri = WEATHER_URI+"cityName="+CityName;
		saveWeatherData(uri);
	}
	
	private void saveWeatherData(String uri) {
		String key = uri;
		String strBody = null;
		// 调用服务接口来获取
 		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

 		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}
		
		// 数据写入缓存
 		redisTemplate.opsForValue().set(key, strBody,TIME_OUT,TimeUnit.SECONDS);

	}
	
	
	
	
	
	

}
