package org.micor.weather.basic.job;

import java.util.List;

import org.micor.weather.basic.service.CityDataService;
import org.micor.weather.basic.service.WeatherDataService;
import org.micor.weather.basic.vo.City;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;


public class WeatherDataSyncJob extends QuartzJobBean{

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityDataService cityDataService;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		LOG.info(" executeInternal  begin");	
		List<City> cityList = null;
		
		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 LOG.error("exception :{}",e);
		}
//		cityList.forEach((a)-> {
//			LOG.info(" city name :{}",a.getCityName());
//		  String cityName = a.getCityName();
//		   weatherService.getDataByCityName(cityName);
//		});
	}
	
	
}
