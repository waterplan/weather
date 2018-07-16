package com.micro.example.collection.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.micro.example.collection.service.CityClientService;
import com.micro.example.collection.service.WeatherDataCollectionService;
import com.micro.example.collection.vo.City;

@Component
public class WeatherDataSyncJob extends QuartzJobBean{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CityClientService cityCilentService;

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		LOG.info(" executeInternal  begin");	
		List<City> cityList = null;
		
		try {
			cityList = cityCilentService.cityList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 LOG.error("exception :{}",e);
		}
		cityList.forEach((a)-> {
			LOG.info(" city name :{}",a.getCityName());
		  String cityName = a.getCityName();
		  weatherDataCollectionService.syncDateByCityName(cityName);
		});
	}
	
	
}
