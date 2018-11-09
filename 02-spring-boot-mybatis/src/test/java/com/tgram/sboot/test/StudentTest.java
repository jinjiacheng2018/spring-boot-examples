package com.tgram.sboot.test;

import com.tgram.sboot.dao.StudentDao;
import com.tgram.sboot.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void test01(){
        List<Student> students = studentDao.queryAllStudents();

        students.forEach(student -> {
            System.out.println(student);
        });
    }

}
