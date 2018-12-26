package com.tgram.sboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.tgram.sboot.util.MyDateUtil;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
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

    /**
     * 测试配置类配置数据源
     */
    @Test
    public void test2(){
        System.err.println(druidDataSource);
    }

    /**
     * 测试日期工具类
     */
    @Test
    public void test3(){
        String dateStr = "2018-12-26";
        Date date = MyDateUtil.parseDate(dateStr, "yyyy-MM-dd");
        System.out.println(date);

        Date startDate = MyDateUtil.incr(date, -30);
        Date endDate = MyDateUtil.incr(date, 30);

        System.out.println("----> " + MyDateUtil.dateFormate(startDate,"yyyy-MM-dd HH:mm:ss"));
        System.out.println("****> " + MyDateUtil.dateFormate(endDate,"yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 测试日期相关
     */
    @Test
    public void testDate(){
        Date date = new Date();
        System.out.println(MyDateUtil.dateFormate(date,"yyyy-MM-dd"));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-30);
        System.out.println(calendar.getTime() + " <-> " + MyDateUtil.dateFormate(calendar.getTime(),"yyyy-MM-dd"));

        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,30);
        System.out.println(calendar.getTime() + " <*> " + MyDateUtil.dateFormate(calendar.getTime(),"yyyy-MM-dd"));
    }

    /**
     * 测试日历类
     */
    @Test
    public void testDate2(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(MyDateUtil.dateFormate(calendar.getTime(),"yyyy-MM-dd HH:mm:ss E"));

        // 六个(或三个)参数设置日期
        calendar.set(2019,0,1,14,14,14);
        System.out.println(MyDateUtil.dateFormate(calendar.getTime(),"yyyy-MM-dd HH:mm:ss E"));
    }

    /**
     * JDK8的日期类
     */
    @Test
    public void testDate3(){
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);

        LocalDate localDate2 = LocalDate.of(2019,1,1);
        System.out.println(localDate2);

        // LocalDate转成Date
        Date date1 = MyDateUtil.localDateToDate(localDate1);
        Date date2 = MyDateUtil.localDateToDate(localDate2);

        System.out.println(MyDateUtil.dateFormate(date1,"yyyy-MM-dd HH:mm:ss E"));
        System.out.println(MyDateUtil.dateFormate(date2,"yyyy-MM-dd HH:mm:ss E"));

        // Date转成LocalDate
        Date date = new Date();
        LocalDate localDate = MyDateUtil.dateToLocalDate(date);
        System.out.println(localDate1);
    }

    /**
     * 测试JDK8去除List集合中重复的元素
     */
    @Test
    public void testJdk8List(){
        List<String> list = Arrays.asList("helloworld","java","oracle","c","c#","oracle");
        list.forEach(str -> System.out.print(str + "  "));

        System.out.println();

        // 去除重复之后需要使用一个新的集合集合
        // List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        // list2.forEach(str2 -> System.out.print(str2 + "  "));

        list.stream().distinct().collect(Collectors.toList()).forEach(str3 -> System.out.print(str3 + "  "));
    }
}
