package com.micro.weather.city.eureka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.weather.city.eureka.dao.CityInfoDao;
import com.micro.weather.city.eureka.domain.City;
@Service
public class CityDataServiceImpl implements CityDataService {
	
	@Autowired
	private CityInfoDao cityInfoDao;

	@Override
	public List<City> listCity() throws Exception {
		List<City> list = cityInfoDao.queryAll();
		return list;
	}

	
	@Override
	public void insertCity(City city) {
		cityInfoDao.insert(city);
	}

}
