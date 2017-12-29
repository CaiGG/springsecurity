package com.springsecurity.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for(int i=0; i<100; i++){
            asyncTaskService.executorAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
