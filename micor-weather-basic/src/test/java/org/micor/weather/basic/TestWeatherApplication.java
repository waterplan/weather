package org.micor.weather.basic;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.micor.weather.basic.service.CityDataService;
import org.micor.weather.basic.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWeatherApplication {

	@Autowired
	private CityDataService cityDataService;
	
	@Test
	public void test() throws Exception {
		List<City> listCity = cityDataService.listCity();
		listCity.forEach((a) -> System.out.println(a.getCityName()));
	}
	
	
}
