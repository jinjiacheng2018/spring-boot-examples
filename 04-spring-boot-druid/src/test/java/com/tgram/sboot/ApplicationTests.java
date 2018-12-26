package com.tgram.sboot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
import com.tgram.sboot.entity.Employee;
import com.tgram.sboot.lambda.MyLambadFunc;
import com.tgram.sboot.util.MyDateUtil;
import com.tgram.sboot.util.StringFuncUtil;

// @RunWith(SpringRunner.class)
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
    
    private List<Employee> employees = new ArrayList<Employee>();
    
    private Employee[] emps = new Employee[5];
    
    {
        employees.add(new Employee(1, "Tom", 25, "XiangYang"));
        employees.add(new Employee(5, "Jack", 35, "HangZhou"));
        employees.add(new Employee(2, "Tony", 20, "ShangHai"));
        employees.add(new Employee(4, "King", 22, "BeiJing"));
        employees.add(new Employee(3, "Bob", 40, "ShenZhen"));
    }
    
    {
        emps[0] = new Employee(1, "Tom", 25, "XiangYang");
        emps[1] = new Employee(5, "Jack", 35, "HangZhou");
        emps[2] = new Employee(2, "Tony", 20, "ShangHai");
        emps[3] = new Employee(4, "King", 22, "BeiJing");
        emps[4] = new Employee(3, "Bob", 40, "ShenZhen");
    }
    
    @Test
    public void contextLoads() throws SQLException
    {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from mydatabase.employee");
        
        while (resultSet.next())
        {
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
    public void test1()
    {
        System.out.println(environment.getProperty("spring.datasource.driver-class-name"));
    }
    
    /**
     * 测试配置类配置数据源
     */
    @Test
    public void test2()
    {
        System.err.println(druidDataSource);
    }
    
    /**
     * 测试日期工具类
     */
    @Test
    public void test3()
    {
        String dateStr = "2018-12-26";
        Date date = MyDateUtil.parseDate(dateStr, "yyyy-MM-dd");
        System.out.println(date);
        
        Date startDate = MyDateUtil.incr(date, -30);
        Date endDate = MyDateUtil.incr(date, 30);
        
        System.out.println("----> " + MyDateUtil.dateFormate(startDate, "yyyy-MM-dd HH:mm:ss"));
        System.out.println("****> " + MyDateUtil.dateFormate(endDate, "yyyy-MM-dd HH:mm:ss"));
    }
    
    /**
     * 测试日期相关
     */
    @Test
    public void testDate()
    {
        Date date = new Date();
        System.out.println(MyDateUtil.dateFormate(date, "yyyy-MM-dd"));
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        System.out.println(calendar.getTime() + " <-> " + MyDateUtil.dateFormate(calendar.getTime(), "yyyy-MM-dd"));
        
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        System.out.println(calendar.getTime() + " <*> " + MyDateUtil.dateFormate(calendar.getTime(), "yyyy-MM-dd"));
    }
    
    /**
     * 测试日历类
     */
    @Test
    public void testDate2()
    {
        Calendar calendar = Calendar.getInstance();
        System.out.println(MyDateUtil.dateFormate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss E"));
        
        // 六个(或三个)参数设置日期
        calendar.set(2019, 0, 1, 14, 14, 14);
        System.out.println(MyDateUtil.dateFormate(calendar.getTime(), "yyyy-MM-dd HH:mm:ss E"));
    }
    
    /**
     * JDK8的日期类
     */
    @Test
    public void testDate3()
    {
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        
        LocalDate localDate2 = LocalDate.of(2019, 1, 1);
        System.out.println(localDate2);
        
        // LocalDate转成Date
        Date date1 = MyDateUtil.localDateToDate(localDate1);
        Date date2 = MyDateUtil.localDateToDate(localDate2);
        
        System.out.println(MyDateUtil.dateFormate(date1, "yyyy-MM-dd HH:mm:ss E"));
        System.out.println(MyDateUtil.dateFormate(date2, "yyyy-MM-dd HH:mm:ss E"));
        
        // Date转成LocalDate
        Date date = new Date();
        LocalDate localDate = MyDateUtil.dateToLocalDate(date);
        System.out.println(localDate1);
    }
    
    /**
     * 测试JDK8去除List集合中重复的元素
     */
    @Test
    public void testJdk8List()
    {
        List<String> list = Arrays.asList("helloworld", "java", "oracle", "c", "c#", "oracle");
        list.forEach(str -> System.out.print(str + "  "));
        
        System.out.println();
        
        // 去除重复之后需要使用一个新的集合集合
        // List<String> list2 = list.stream().distinct().collect(Collectors.toList());
        // list2.forEach(str2 -> System.out.print(str2 + "  "));
        
        list.stream().distinct().collect(Collectors.toList()).forEach(str3 -> System.out.print(str3 + "  "));
    }
    
    /**
     * 测试Jdk8的集合排序
     */
    @Test
    public void testJdk8_1()
    {
        for (Employee emp : emps)
        {
            System.out.println(emp);
        }
        
        Arrays.sort(emps, new Comparator<Employee>()
        {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                return o1.getEmpAge().compareTo(o2.getEmpAge());
            }
        });
        
        System.out.println("---------------------------------");
        
        for (Employee emp : emps)
        {
            System.out.println(emp);
        }
    }
    
    /**
     * 使用Lambda表达式没有调用已有的方法排序
     */
    @Test
    public void testJdk8_2()
    {
        Arrays.sort(emps, (Employee a, Employee b) -> {
            return a.getEmpAge().compareTo(b.getEmpAge());
        });
        
        for (Employee emp : emps)
        {
            System.out.println(emp);
        }
    }
    
    /**
     * 使用Lambda表达式调用已有的方法排序
     */
    @Test
    public void testJdk8_3()
    {
        Arrays.sort(emps, (a, b) -> Employee.compareByAge(a, b));
        
        for (Employee emp : emps)
        {
            System.out.println(emp);
        }
    }
    
    /**
     * 使用Lambda表达式直接使用方法引用
     */
    @Test
    public void testJdk8_4()
    {
        Arrays.sort(emps, Employee::compareByAge);
        
        for (Employee emp : emps)
        {
            System.out.println(emp);
        }
    }

    /**
     * 使用Lambda表达式实现函数式接口表达式
     */
    @Test
    public void testJdk8Lambda(){
        String string = "lambda add power to Java";
        String string1 = MyLambadFunc.resverseStringFunc(StringFuncUtil::reverseString,string);
        System.out.println(string1);
    }
}
