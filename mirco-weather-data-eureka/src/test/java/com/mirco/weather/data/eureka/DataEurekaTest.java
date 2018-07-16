package com.mirco.weather.data.eureka;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mirco.weather.data.eureka.service.WeatherDataService;
import com.mirco.weather.data.eureka.vo.WeatherResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataEurekaTest {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	WeatherDataService weatherDataService;
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		WeatherResponse response = weatherDataService.getDataByCityName("深圳");
		LOG.info("test  method :{}",response);
	}
}
