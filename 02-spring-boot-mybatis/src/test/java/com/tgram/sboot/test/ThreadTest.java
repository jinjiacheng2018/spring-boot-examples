package com.tgram.sboot.test;

import com.tgram.sboot.entity.Student;
import com.tgram.sboot.service.StudentService;
import com.tgram.sboot.uitl.ThreadUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *<p> Description: 线程测试类 </p>
 *<p> Copyright: Copyright(c) 2018/12/27 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/27 14:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ThreadTest
{
    
    @Autowired
    private StudentService studentService;
    
    /**
     * 开启线程查询数据库 334
     */
    @Test
    public void testThread1()
    {
        // 1.获取FutureTask对象
        ThreadUtil threadUtil = new ThreadUtil(studentService);
        FutureTask futureTask = new FutureTask(threadUtil);
        
        ThreadUtil threadUtil2 = new ThreadUtil(studentService);
        FutureTask futureTask2 = new FutureTask(threadUtil2);
        
        // 2.开启线程
        new Thread(futureTask).start();
        new Thread(futureTask2).start();
        
        try
        {
            List<Student> studentList = (List<Student>) futureTask.get();
            studentList.forEach(student -> System.out.println(student));
            
            List<Student> studentList2 = (List<Student>) futureTask2.get();
            studentList2.forEach(student2 -> System.err.println(student2));
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 开启线程查询数据库
     */
    @Test
    public void testThread2()
    {
        List<Student> studentList = studentService.allStudentsList();
        studentList.forEach(student -> System.out.println(student));
        
        List<Student> studentList2 = studentService.allStudentsList();
        studentList2.forEach(student2 -> System.err.println(student2));
    }
}
