package com.tgram.sboot.dao;

import com.tgram.sboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:22
 */
@Mapper
public interface StudentDao {

    /**
     * 查询所有的学生信息列表
     * @return List<Student>
     */
    List<Student> queryAllStudents();

}
