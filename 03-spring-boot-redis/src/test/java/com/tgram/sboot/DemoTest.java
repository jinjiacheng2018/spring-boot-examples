package com.tgram.sboot;

import com.tgram.sboot.dao.EmployeeDao;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *<p> Description: 测试 </p>
 *<p> Copyright: Copyright(c) 2018/12/11 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/11 17:42
 */
@RunWith(SpringRunner.class)
public class DemoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void test_01(){
        String string = "异常：实际名称;经营类型;开设地址;";
        String[] split = string.split(";");

        for (String s : split) {
            System.err.print(s + " ");
        }
    }

    @Test
    public void test_02(){
        String string = "异常：实际名称;";
        String[] split = string.split(";");

        for (String s : split) {
            System.err.print(s + " ");
        }
    }

    @Test
    public void testDataSource()
    {
        System.out.println(employeeDao);
    }
}
