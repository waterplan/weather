package org.micor.weather.basic.listener;

import org.micor.weather.basic.configuration.QuartzConfiguration;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class SchedulerListener  implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	public QuartzConfiguration auartz;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		try {
			auartz.scheduleJobs();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		return factoryBean;
	}
}
