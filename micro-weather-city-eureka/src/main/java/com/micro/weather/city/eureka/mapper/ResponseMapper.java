/**
 * 
 */
package com.micro.weather.city.eureka.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.micro.weather.city.eureka.domain.ResponseVO;

/**
 * @author zeng
 */
public class ResponseMapper implements RowMapper<ResponseVO>{

	@Override
	public ResponseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResponseVO responseVO = new ResponseVO();
		responseVO.setId(rs.getInt("id"));
		responseVO.setWeatherData(rs.getString("weather_data"));
		responseVO.setCityCode(rs.getString("city_code"));
		responseVO.setRequestUrl(rs.getString("request_url"));
		responseVO.setCrUser(rs.getString("cr_user"));
		responseVO.setCrDate(rs.getDate("cr_date"));
		responseVO.setUpUser(rs.getString("up_user"));
		responseVO.setUpDate(rs.getDate("up_date"));
		responseVO.setDeleteFlag(rs.getInt("delete_flag"));
		return responseVO;
	}

}
