package com.project.scheduler;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfiguration {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder
                .newJob(UpdaterJob.class)
                .withIdentity("updater job")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder
                .newTrigger()
                .forJob(job)
                .withIdentity("updater trigger")
                .startNow()
                .withSchedule(
                        CronScheduleBuilder
//                                .cronSchedule("0 * * * * ? *")
                                .cronSchedule("0 0 0 1 * ? *")
                ).build();

//        Trigger trigger = new
//        trigger.setJobDetail(job);
//        trigger.setStartDelay(0);
//        trigger.setRepeatInterval(300000);
//        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//        return trigger;
    }

//    @Bean
//    @Qualifier("startupTrigger")
//    public SimpleTriggerFactoryBean startupTrigger(JobDetail job) {
//        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//        trigger.setJobDetail(job);
//        trigger.setStartDelay(0);
//        return trigger;
//    }
//
//    @Bean
//    @Qualifier("foreverTrigger")
//    public SimpleTriggerFactoryBean foreverTrigger(JobDetail job) {
//        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
//        trigger.setJobDetail(job);
//        //trigger.setRepeatInterval(2592000000L); // runs every 30 days
//        trigger.setRepeatInterval(300000); // runs every 5 mins
//        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
//        return trigger;
//    }

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(Trigger startupTrigger, Trigger foreverTrigger, JobDetail jobDetail) {
//        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//        schedulerFactory.setTriggers(startupTrigger, foreverTrigger);
//        schedulerFactory.setJobDetails(jobDetail);
//        return schedulerFactory;
//    }
}
