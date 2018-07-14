package org.micor.weather.basic.configuration;

import java.util.concurrent.Executors;

import org.micor.weather.basic.job.WeatherDataSyncJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;


@Configuration
//@EnableScheduling
public class QuartzConfiguration {
	
	private static final int TIME = 2; // 更新频率

/*   springboot 自带的
	@Scheduled(fixedRate = 5000)
	public void scheduleUpdateCronTrigger() throws SchedulerException {
		System.out.println("5s运行一次，测试用的");
	}
*/

	@Autowired
	SchedulerFactoryBean  schedulerFactoryBean ;

	static Scheduler scheduler;
	
	public void scheduleJobs() throws SchedulerException {
		scheduler = schedulerFactoryBean.getScheduler();
		startJob(); // 每15分钟执行一次
	}

	
	public static void startJob() throws SchedulerException{
		JobDetail detail = JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("job1","goup1").build();
		CronScheduleBuilder scheduleBuilder =CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
		CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1").withSchedule(scheduleBuilder).build();
		scheduler.scheduleJob(detail,cronTrigger);
	}
	public static void modifyJob1(String cron) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
		CronTrigger newTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
				.withSchedule(scheduleBuilder).build();
		scheduler.rescheduleJob(triggerKey, newTrigger);
	}
	public static String getJob1Status() throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
		return scheduler.getTriggerState(triggerKey).name();
	}
	public static void pauseJob1() throws SchedulerException {
		scheduler.pauseJob(JobKey.jobKey("job1", "group1"));
	}
	public static void resumeJob1() throws SchedulerException {
		scheduler.resumeJob(JobKey.jobKey("job1", "group1"));
	}
	
}
