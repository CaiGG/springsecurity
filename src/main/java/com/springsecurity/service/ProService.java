package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProService {

    @Autowired
    private UserService userService;

    public void print(){
        userService.print();
    }
}
