package com.micro.example.collection.listener;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.micro.example.collection.configuration.QuartzConfiguration;
@Component
public class SchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QuartzConfiguration quartz;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		LOG.info("onApplicationEvent start");
		try {
			quartz.startJob();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
