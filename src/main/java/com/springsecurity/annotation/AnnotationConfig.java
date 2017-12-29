package com.springsecurity.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //组合@Configuratino元注解
@ComponentScan  //组合@ConponentScan元注解
public @interface AnnotationConfig {
    //覆盖value参数
    String[] value() default {};
}
