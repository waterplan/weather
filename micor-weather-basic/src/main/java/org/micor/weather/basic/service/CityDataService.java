package org.micor.weather.basic.service;

import java.util.List;

import org.micor.weather.basic.vo.City;

public interface CityDataService {

	
	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
