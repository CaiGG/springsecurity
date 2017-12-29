package com.springsecurity.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AwareService implements BeanNameAware,ResourceLoaderAware {

    private String name;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("Bean Name is :" + name);
        Resource resource = loader.getResource("classpath:application.properties");
        try{
            System.out.println("ResourceLoader 加载文件内容为： " + IOUtils.toString(resource.getInputStream(),"UTF-8"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
