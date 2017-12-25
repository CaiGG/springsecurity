package com.springsecurity.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
//方法安全
@EnableGlobalMethodSecurity(securedEnabled = true)
public class HelloController {
    @RequestMapping("/")
    public ModelAndView index (){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login (){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping("/privilege")
    public ModelAndView privilege (){
        ModelAndView mav = new ModelAndView("privilege");
        return mav;
    }

    @RequestMapping("/success")
    public ModelAndView success (){
        ModelAndView mav = new ModelAndView("success");
        return mav;
    }
    @RequestMapping("/print/{name}")
    public String print(@PathVariable("name")String name){
        return name;
    }
    @RequestMapping("/print")
    public String print2(@RequestParam String name){
        return name;
    }

    @RequestMapping("/my/logout")
    public void logout(){
    }


    //方法安全
    @RequestMapping("/admin")
    @Secured(value = "ROLE_USER")
    public String admin(){
        return "admin";
    }

   /* @RequestMapping("/admin")
    @Secured(value = "ROLE_USER")
    public String user(){
        return "USER";
    }*/
}
