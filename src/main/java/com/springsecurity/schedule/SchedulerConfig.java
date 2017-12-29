package com.springsecurity.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.springsecurity.schedule")
//通过@EnableScheduling注解开启计划任务的支持
@EnableScheduling
public class SchedulerConfig {
}
