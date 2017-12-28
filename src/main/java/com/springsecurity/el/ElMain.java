package com.springsecurity.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Spring El 表达式
 */
public class ElMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig el = context.getBean(ElConfig.class);
        el.outputResource();
        context.close();
    }
}
