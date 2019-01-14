/**
 * 
 */
package com.micro.weather.city.eureka.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.micro.weather.city.eureka.domain.City;

/**
 * @author zeng
 */
public class CityMapper implements RowMapper<City> {

	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();
		city.setId(rs.getInt("id"));
		city.setPid(rs.getInt("pid"));
		city.setCityCode(rs.getString("city_code"));
		city.setCityName(rs.getString("city_name"));
		city.setCrUser(rs.getString("cr_user"));
		city.setCrDate(rs.getDate("cr_date"));
		city.setUpUser(rs.getString("up_user"));
		city.setUpDate(rs.getDate("up_date"));
		return city;
	}

}
