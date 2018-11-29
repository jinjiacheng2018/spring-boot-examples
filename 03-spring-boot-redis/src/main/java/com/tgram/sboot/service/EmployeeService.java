package com.tgram.sboot.service;

import com.tgram.sboot.entity.Employee;

import java.util.List;

/**
 *<p> Description: 雇员服务层 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 17:13
 */
public interface EmployeeService {

    /**
     * 获取所有的雇员信息对象
     * @return
     */
    List<Employee> queryAllEmps();

    /**
     * 通过雇员编号获取雇员对象
     * @param empId
     * @return
     */
    Employee queryEmpById(Integer empId);
}
