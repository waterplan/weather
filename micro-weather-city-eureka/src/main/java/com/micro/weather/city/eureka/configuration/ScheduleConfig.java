/**
 * 
 */
package com.micro.weather.city.eureka.configuration;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author zeng
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer{

	private int cronThreadPoolSize = 6;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(Executors.newScheduledThreadPool(cronThreadPoolSize));
	}

	
	
}
