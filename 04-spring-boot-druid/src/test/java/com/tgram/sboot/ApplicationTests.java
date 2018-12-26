package com.tgram.sboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{
    /**
     * 自动注入配置类
     */
    // @Autowired
    private DataSource dataSource;

    @Autowired
    private Environment environment;

    @Autowired
    private DruidDataSource druidDataSource;

    @Test
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mydatabase.employee");

        while (resultSet.next()){
            int emp_id = resultSet.getInt("emp_id");
            String emp_name = resultSet.getString("emp_name");
            int emp_age = resultSet.getInt("emp_age");
            String emp_address = resultSet.getString("emp_address");
            System.out.println(emp_id + " - " + emp_name + " - " + emp_age + " - " + emp_address);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    /**
     * 通过Enviroment对象获取配置文件的属性
     */
    @Test
    public void test1(){
        System.out.println(environment.getProperty("spring.datasource.driver-class-name"));
    }

    @Test
    public void test2(){
        System.err.println(druidDataSource);
    }
}
