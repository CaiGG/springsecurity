
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

@Configuration
public class SpringConfig extends SpringMvcConfig {

    @Bean
    ProInterceptor proInterceptor(){
        return new ProInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
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

