package com.springsecurity.config;

import com.springsecurity.Interceptor.UserInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{




    @Bean
    UserInterceptor userInterceptor(){
        return new UserInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*super.addInterceptors(registry);*/
        UserInterceptor userInterceptor = userInterceptor();
        registry.addInterceptor(userInterceptor()).addPathPatterns("/success");
    }

}
