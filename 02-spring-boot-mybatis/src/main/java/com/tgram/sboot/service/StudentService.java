package com.tgram.sboot.service;

import com.tgram.sboot.entity.Student;

import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:38
 */
public interface StudentService {

    /**
     * 查询所有的学生信息里列表
     * @return List<Student>
     */
    List<Student> allStudentsList();

}
