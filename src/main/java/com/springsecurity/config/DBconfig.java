package com.springsecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;


@Configuration
public class DBconfig {

    @Autowired
    private Environment environment;


    @Bean("dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(environment.getProperty("ms.db.driverClassName"));
        comboPooledDataSource.setUser(environment.getProperty("ms.db.username"));
        comboPooledDataSource.setPassword(environment.getProperty("ms.db.password"));
        comboPooledDataSource.setJdbcUrl(environment.getProperty("ms.db.url"));
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setInitialPoolSize(5);
        comboPooledDataSource.setMaxIdleTime(300);
        comboPooledDataSource.setIdleConnectionTestPeriod(60);
        return  comboPooledDataSource;
    }
}
