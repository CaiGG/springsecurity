package com.springsecurity.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//声明一个切面
@Aspect
//交给sprng管理
@Component
public class LogAspect {

    //注解定义切点
    @Pointcut("@annotation(com.springsecurity.aop.Action)")
    public void annotationPointCut(){};

    //注解声明一个建言，并使用@Pointcut定义的切点
    @After("annotationPointCut()")
    public  void after(JoinPoint joinPoint){
        //通过反射获取注解上的属性
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截" + action.name());
    }

    //通过@Before注解声明一个建言，使用拦截规则作为参数,
    // =============第一个*后面要加空格，否则报错================
    @Before("execution(* com.springsecurity.aop.DemoAnnotationService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截" + method.getName());
    }
}
