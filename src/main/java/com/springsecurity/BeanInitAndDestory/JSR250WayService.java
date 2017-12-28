package com.springsecurity.BeanInitAndDestory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用JSR-250 init和destroy
 */

public class JSR250WayService {

    @PostConstruct
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService(){
        super();
        System.out.println("初始化构造函数-JSR250WayService");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JSR250-destory-method");
    }
}
