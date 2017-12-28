
package com.springsecurity.config;

import com.springsecurity.Interceptor.ProInterceptor;
import com.springsecurity.service.ProService;
import com.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;


/**
 * 测试 Interceptor
 *      继承一个已经继承WebMvcConfigurerAdapter的父类SpringMvcConfig
 *      如果SpringConfig 和 SpringMvcConfig都加@Configuration的话，则子类不需调用super.addInterceptors(registry)；
 *      如果SpringConfig调用super.addInterceptors(registry),则父类不需加@Configuration,否则会出现重复的Interceptor
 */
@Configuration
public class SpringConfig extends SpringMvcConfig {

    @Bean
    ProInterceptor proInterceptor(){
        return new ProInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*super.addInterceptors(registry);*/
        registry.addInterceptor(proInterceptor()).addPathPatterns("/admin");
    }
    @Bean
    FilterRegistrationBean delegatingFilterRegistrationBean (){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(delegatingFilterProxy());
        filter.addUrlPatterns("/*");
        filter.setName("springSecurityFilterChain");
        return filter;
    }
    @Bean
    DelegatingFilterProxy delegatingFilterProxy(){
        return new DelegatingFilterProxy();
    }

}

