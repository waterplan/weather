/**
 * 
 */
package com.micro.weather.city.eureka.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.micro.weather.city.eureka.domain.City;
import com.micro.weather.city.eureka.mapper.CityMapper;

/**
 * @author zeng
 */
@Service
public class CityInfoDaoImpl implements CityInfoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insert(City cityInfo) {
		jdbcTemplate.update("insert into city(pid, city_code, city_name) values(?,?,?)",cityInfo.getPid(), cityInfo.getCityCode(), cityInfo.getCityName());
	}


	@Override
	public List<City> queryAll() {
		RowMapper<City> rowMapper = new CityMapper();
		List<City> list = jdbcTemplate.query("select * from city", rowMapper);
		return list;
	}


	@Override
	public List<City> queryByPid(int pid) {
		RowMapper<City> rowMapper = new CityMapper();
		List<City> list = jdbcTemplate.query("select * from city where pid = ?",new Object[] {pid}, rowMapper);
		return list;	
		}


	/* (non-Javadoc)
	 * @see com.micro.weather.city.eureka.dao.CityInfoDao#getOneByCityCode(java.lang.String)
	 */
	@Override
	public City getOneByCityCode(String cityCode) {
		City city = jdbcTemplate.queryForObject("select * from city where city_code = "+cityCode, new CityMapper());
		return city;
	}


	/* (non-Javadoc)
	 * @see com.micro.weather.city.eureka.dao.CityInfoDao#getOneByCityName(java.lang.String)
	 */
	@Override
	public City getOneByCityName(String cityName) {
		City city = jdbcTemplate.queryForObject("select * from city where city_name = "+cityName, new CityMapper());
		return city;
	}

}
