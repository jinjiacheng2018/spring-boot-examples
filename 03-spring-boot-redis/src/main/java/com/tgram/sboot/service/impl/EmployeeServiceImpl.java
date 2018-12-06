package com.tgram.sboot.service.impl;

import com.tgram.sboot.dao.EmployeeDao;
import com.tgram.sboot.entity.Employee;
import com.tgram.sboot.service.EmployeeService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *<p> Description: 服务实现层 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 17:14
 */
@EnableScheduling
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> queryAllEmps() {
        return employeeDao.queryAllEmps();
    }

    @Override
    public Employee queryEmpById(Integer empId) {
        return employeeDao.queryEmpById(empId);
    }

    /**
     * 定时任务：使用cron表示每隔5秒执行一次，注意使用@Scheduled定时任务的注解，需要在对应的Bean上添加@EnableScheduling注解
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void autoScheduled(){
        System.err.println("auto run....");
    }
}
