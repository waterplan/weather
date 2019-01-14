/**
 * 
 */
package com.micro.weather.city.eureka.dao;

import java.util.List;

import com.micro.weather.city.eureka.domain.City;

/**
 * @author zeng
 */
public interface CityInfoDao {

	
   void	insert(City cityInfo);
   
   List<City> queryAll();
   
   List<City> queryByPid(int pid);
   
   City getOneByCityCode(String cityCode);
	
   City getOneByCityName(String cityName);
	
}
