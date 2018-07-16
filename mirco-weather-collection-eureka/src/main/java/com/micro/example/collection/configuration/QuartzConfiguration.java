package com.micro.example.collection.configuration;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.micro.example.collection.factory.SpringJobFactory;
import com.micro.example.collection.job.WeatherDataSyncJob;


@Configuration
public class QuartzConfiguration {


	@Autowired
	private SpringJobFactory springJobFactory;
	


	
	public void startJob() throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(WeatherDataSyncJob.class).build();
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/30 * * * ?");
		CronTrigger cronTrigger = TriggerBuilder.newTrigger()
				.withSchedule(scheduleBuilder).build();
	     scheduler().scheduleJob(jobDetail, cronTrigger);
	}
	
	
	

	@Bean
	public Scheduler scheduler() {
		return schedulerFactoryBean().getScheduler();
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		 SchedulerFactoryBean bean = new SchedulerFactoryBean();
		 bean.setJobFactory(springJobFactory);
		 return bean;
	}


	
}
