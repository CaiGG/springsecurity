package com.springsecurity.Interceptor;

import com.springsecurity.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ProService proService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        proService.print();
        System.out.println("ProInterceptor");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String name = ((UserDetails)principal).getUsername();
            System.out.println(name);
        }
        System.out.println(principal);
        return super.preHandle(request, response, handler);
    }
}
