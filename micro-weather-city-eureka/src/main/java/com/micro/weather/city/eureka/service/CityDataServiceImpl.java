package com.micro.weather.city.eureka.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.micro.weather.city.eureka.util.XmlBuilder;
import com.micro.weather.city.eureka.vo.City;
import com.micro.weather.city.eureka.vo.CityList;
@Service
public class CityDataServiceImpl implements CityDataService {

	@Override
	public List<City> listCity() throws Exception {
		// TODO Auto-generated method stub
		Resource resource = new ClassPathResource("cityList.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
			String line = "";
			StringBuffer sb = new StringBuffer();
			while( (line = br.readLine())!=null) {
				sb.append(br.readLine());
			}
			if(br!=null) {
				br.close();
			}
			CityList CityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, sb.toString());
		return CityList.getCityList();
	}

}
