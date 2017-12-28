package com.springsecurity.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.springsecurity.aop")
//使用@EnableAspectJAutProxy注解开启Spring对AspectJ代理的支持
@EnableAspectJAutoProxy
public class AopConfig {


}
