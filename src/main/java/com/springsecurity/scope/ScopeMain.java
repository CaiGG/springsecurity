package com.springsecurity.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
        DemoSingletonService demoSingletonService = context.getBean(DemoSingletonService.class);
        DemoSingletonService demoSingletonService2 = context.getBean(DemoSingletonService.class);
        DemoPrototypeService demoPrototypeService = context.getBean(DemoPrototypeService.class);
        System.out.println("demoSingletonService 与 demoPrototypeService 是否相等：" + demoPrototypeService.equals(demoSingletonService));
        System.out.println("demoSingletonService 与 demoSingletonService2 是否相等：" + demoSingletonService2.equals(demoSingletonService));
    }
}
