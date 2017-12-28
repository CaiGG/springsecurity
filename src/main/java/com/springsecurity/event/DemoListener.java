package com.springsecurity.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 事件监听器
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我（bean-demoListener）收到Bean-DemoPublisher 发布的消息：" + msg);
        Date d = new Date();
        d.setTime(demoEvent.getTimestamp());
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT +8"));*/
        System.out.println("事件时间为" + demoEvent.getTimestamp() + "：：" + d );
    }
}
