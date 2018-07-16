package com.micro.weather.city.eureka;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.micro.weather.city.eureka.service.CityDataService;
import com.micro.weather.city.eureka.vo.City;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BootCityTest {
	
	@Autowired
	CityDataService cityDataService;
	
	@Test
	public void test() throws Exception {
		List<City> listCity = cityDataService.listCity();
		listCity.forEach((a) ->{
			System.out.println(a.getCityName());
		});
	}

}
