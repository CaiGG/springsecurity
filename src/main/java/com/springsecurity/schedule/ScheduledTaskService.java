package com.springsecurity.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //通过@Scheduled声明该方法时计划任务，使用fixedRate属性每隔固定时间执行
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次" + dateFormat.format(new Date()));
    }

    //使用cron属性可按照固定时间执行，cron是Unix和类unix系统下的定时任务。
    @Scheduled(cron = "0 36 10 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间" + dateFormat.format(new Date()) + "执行");
    }
}
