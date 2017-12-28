package com.springsecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * 设置数据源
 *  - DriverClass
 *  - username
 *  - password
 *  - url
 *  - MaxPoolSize 最多连接数
 *  - MinPoolSize 最少连接数
 *  - InitialPoolSize 初始化连接数
 *  - MaxIdleTime 连接的最大空闲时间，如果超过这个时间，某个数据库连接还没有被使用，则会断开掉这个连接。如果为0，则永远不会断开连接,即回收此连接
 *  - idleConnectionTestPeriod 用来配置测试空闲连接的间隔时间。测试方式还是上面的两种之一，可以用来解决MySQL8小时断开连接的问题。因为它保证连接池会每隔一定时间对空闲连接进行一次测试，从而保证有效的空闲连接能每隔一定时间访问一次数据库，将于MySQL8小时无会话的状态打破。为0则不测试。default : 0(建议使用）
 */

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
