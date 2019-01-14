/**
 * 
 */
package com.micro.weather.city.eureka.dao;

import java.util.List;

import com.micro.weather.city.eureka.domain.ResponseVO;

/**
 * @author zeng
 */
public interface WeatherDao {
	
   List<ResponseVO> queryWeatherAll();
   
   
   List<ResponseVO> queryWeatherLimit();
   
   void insert(ResponseVO responseVO);
   
   ResponseVO getOne(String cityCode);
   
   
   List<ResponseVO> queryWeatherByCityCodeAll(String cityCode);
   
   List<ResponseVO> queryWeatherByCityCodeAnd15mm(String cityCode);

}
