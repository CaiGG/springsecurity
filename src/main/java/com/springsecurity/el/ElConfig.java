package com.springsecurity.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.springsecurity.el")
@PropertySource("classpath:application.properties")
public class ElConfig {

    //注入普通字符串
    @Value("I love you！")
    private String normal;

    //注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String name;

    //注入表达式结果
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private double randomNumber;

    //注入其他Bean属性
    @Value("#{demoService.another}")
    private String fromAnother;

    //注入文件资源
    @Value("classpath:application.properties")
    private Resource testFile;

    //注入网站资源
    @Value("Http://www.baidu.com")
    private Resource textUrl;

    //注入配置文件
    @Value("${book.naem}")
    private String bookName;

    @Autowired
    private Environment environment;

    /*public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(name);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(IOUtils.toString(testFile.getInputStream(),"UTF-8"));
            System.out.println(IOUtils.toString(textUrl.getInputStream(),"UTF-8"));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
