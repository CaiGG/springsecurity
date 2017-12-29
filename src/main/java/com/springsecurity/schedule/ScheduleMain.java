package com.springsecurity.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduleMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SchedulerConfig.class);
    }
}
