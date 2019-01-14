/**
 * 
 */
package com.micro.weather.city.eureka.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.micro.weather.city.eureka.domain.ResponseVO;
import com.micro.weather.city.eureka.mapper.ResponseMapper;

/**
 * @author zeng
 */
@Repository
public class WeatherDaoImpl implements WeatherDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ResponseVO>  queryWeatherAll() {
		RowMapper<ResponseVO> weatherMapper = new ResponseMapper();
		List<ResponseVO> list = jdbcTemplate.query(" select * from weather_data ORDER BY cr_date desc ", weatherMapper);
		return list;
	}

	@Override
	public List<ResponseVO> queryWeatherLimit() {
		RowMapper<ResponseVO> weatherMapper = new ResponseMapper();

		List<ResponseVO> list = jdbcTemplate.query(" select * from weather_data ORDER BY cr_date desc limit 0,10 ", weatherMapper);
		return list;
	}

	@Override
	public void insert(ResponseVO responseVO) {
		jdbcTemplate.update("insert into weather_data(city_code,weather_data,request_url)  values(?,?,?)",responseVO.getCityCode() ,responseVO.getWeatherData(),responseVO.getRequestUrl());
	}

	@Override
	public ResponseVO getOne(String cityCode) {
		List<ResponseVO> list = this.queryWeatherByCityCodeAnd15mm(cityCode);
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<ResponseVO> queryWeatherByCityCodeAll(String cityCode) {
		RowMapper<ResponseVO> mapper = new ResponseMapper();
		List<ResponseVO> list = jdbcTemplate.query(" select * from weather_data where city_code = ? and delete_flag = '1' order by cr_date desc ", new Object [] {cityCode}, mapper);
		return list;
	}


	@Override
	public List<ResponseVO> queryWeatherByCityCodeAnd15mm(String cityCode) {
		RowMapper<ResponseVO> mapper = new ResponseMapper();
		Date  endDate = new Date();
		long time = endDate.getTime() - (1000 * 60 * 15);
		Date beginDate = new Date(time);
		List<ResponseVO> list = jdbcTemplate.query(" select * from weather_data where city_code = ? and delete_flag = '1' and cr_date between ? and ?  order by cr_date desc ", new Object [] {cityCode, beginDate, endDate}, mapper);		
		return list;
	}

}
