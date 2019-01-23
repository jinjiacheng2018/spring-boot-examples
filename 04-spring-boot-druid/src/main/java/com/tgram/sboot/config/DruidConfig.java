package com.tgram.sboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 *<p> Description: 数据源配置类 </p>
 *<p> Copyright: Copyright(c) 2018/12/25 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/25 15:22
 */
@Configuration
public class DruidConfig {

    @Autowired
    private Environment environment;

    /**
     * 配置Druid的属性，和DataSource进行绑定，前缀设置为：spring.datasource
     * 不配置的话，很多初始化的属性是没有绑定的
     * @return DataSource
     */
    // @Bean
    // @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 公司获取数据源的方法
     * @return DruidDataSource
     * @throws SQLException SQLException
     */
    @Bean
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));

        druidDataSource.setInitialSize(environment.getProperty("spring.datasource.initialSize",int.class));
        druidDataSource.setMinIdle(environment.getProperty("spring.datasource.minIdle",int.class));
        druidDataSource.setMaxActive(environment.getProperty("spring.datasource.maxActive",int.class));
        druidDataSource.setMaxWait(environment.getProperty("spring.datasource.maxWait",int.class));

        druidDataSource.setTimeBetweenEvictionRunsMillis(environment.getProperty("spring.datasource.timeBetweenEvictionRunsMillis",int.class));
        druidDataSource.setMinEvictableIdleTimeMillis(environment.getProperty("spring.datasource.minEvictableIdleTimeMillis",int.class));
        druidDataSource.setPoolPreparedStatements(environment.getProperty("spring.datasource.poolPreparedStatements",boolean.class));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(environment.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize",int.class));
        druidDataSource.setValidationQuery(environment.getProperty("spring.datasource.validationQuery"));
        druidDataSource.init();
        return druidDataSource;
    }
}
