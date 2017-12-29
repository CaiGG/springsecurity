package com.springsecurity.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
    // 通过@Async注解表明该方法时异步方法，如果注解在类级别，
    // 则表明该类所有的方都是异步方法，这里的方法自动被注入使用ThreadPoolTaskExecutor
    @Async
    public void executorAsyncTask(Integer i){
        System.out.println("执行异步任务： " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1 ：" + (i +1));
    }
}
