package com.tgram.sboot.service.impl;

import com.tgram.sboot.dao.StudentDao;
import com.tgram.sboot.entity.Student;
import com.tgram.sboot.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:39
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> allStudentsList() {
        return studentDao.queryAllStudents();
    }
}
