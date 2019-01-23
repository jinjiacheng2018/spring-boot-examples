package com.tgram.sboot.uitl;

import java.util.List;
import java.util.concurrent.Callable;

import com.tgram.sboot.entity.Student;
import com.tgram.sboot.service.StudentService;

/**
 *<p>
 * Description: 使用Callable与Future创建可会获取返回值的线程：
 *              使用Callable创建线程和Runnable接口方式创建线程比较相似，
 *              不同的是，Callable接口提供了一个call() 方法作为线程执行体，
 *              而Runnable接口提供的是run()方法，同时，call()方法可以有返回值，
 *              而且需要用FutureTask类来包装Callable对象
 *</p>
 *<p> Copyright: Copyright(c) 2018/12/27 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/27 14:15
 */
public class ThreadUtil implements Callable {

    private StudentService studentService;

    public ThreadUtil() {
    }

    public ThreadUtil(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 重写call()方法，查询数据库
     * @return List<Student>
     * @throws Exception 异常
     */
    @Override
    public List<Student> call() throws Exception {
        List<Student> students = studentService.allStudentsList();
        return students;
    }
}
