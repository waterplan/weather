package com.micro.weather.city.eureka.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class WeatherCityConfiguration {
	
	@Autowired
	private RestTemplateBuilder builder;
	
	
	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}
	
	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/onc");
		dataSource.setUsername("dev");
		dataSource.setPassword("abcd1234");
		return dataSource;
	}

}
