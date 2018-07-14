package org.micor.weather.basic.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.micor.weather.basic.util.XmlBuilder;
import org.micor.weather.basic.vo.City;
import org.micor.weather.basic.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


@Service
public class CityDataServiceImpl implements CityDataService {
	

	
	
	@Override
	public List<City> listCity() throws Exception {
		Resource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		System.out.println(" listCity");
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";
		while( StringUtils.isNotEmpty((line = br.readLine())) ) {
			stringBuffer.append(br.readLine());
		}
		br.close();
		
		 CityList city = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());
		return city.getCityList();
	}

}
