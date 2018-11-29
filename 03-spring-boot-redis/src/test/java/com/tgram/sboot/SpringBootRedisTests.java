package com.tgram.sboot;

import com.tgram.sboot.dao.EmployeeDao;
import com.tgram.sboot.entity.Employee;
import com.tgram.sboot.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisTests
{
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testMethod1()
    {
        System.out.println(employeeDao.queryEmpById(1));
    }

    @Test
    public void testMethod2(){
        List<Employee> employees = employeeDao.queryAllEmps();

        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }

    @Test
    public void testMethod3(){
        List<Employee> employees = employeeService.queryAllEmps();

        employees.forEach(employee -> {
            System.out.println(employee);
        });
    }
    
}
