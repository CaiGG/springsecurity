package com.springsecurity.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  dao 扫描器
 *  第一，无需指定引用SqlSessionFactory，因为MapperScannerConfigurer在创建映射器时会通过自动装配的方式来引用。
 *  第二，创建的映射器的命名问题。从beans.xml文件中我们可以看出，我们没有办法给MapperScannerConfigurer创建的这些映射器指定id或name属性，它们对我们似乎是不可见的。这个问题的解决之道在于采用了Spring针对自动侦测到的组件的默认命名策略，亦即把类/接口名字的首字母小写，其他不变，作为映射器的名字。例如，映射器接口TeacherMapper被扫描后创建的映射器bean名为teacherMapper。因此，我们可以像以前一样使用这样的代码来得到TeacherMapper实例：
 */
@Configuration
public class MyBatisScannerConfig {


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.springsecurity.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }
}
