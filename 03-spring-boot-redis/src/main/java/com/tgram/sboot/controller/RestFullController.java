package com.tgram.sboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tgram.sboot.core.Message;
import com.tgram.sboot.entity.Employee;
import com.tgram.sboot.service.EmployeeService;

/**
 *<p> Description: RestFull风格的控制层 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 15:42
 */
@RestController
public class RestFullController
{
    
    @Resource
    private EmployeeService employeeService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 测试Rest风格的方法1
     * @return
     */
    @RequestMapping("/restFullIndex")
    public String restFullIndex()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allEmps", employeeService.queryAllEmps());
        
        return Message.data(jsonObject).toJson();
    }
    
    /**
     * 测试Rest风格的方法2-使用Post请求
     * @return
     */
    @PostMapping("/restFullIndexByPost")
    public String restFullIndexByPost()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allEmps", employeeService.queryAllEmps());
        
        return Message.data(jsonObject).toJson();
    }

    /**
     * 通过Id查询雇员信息
     * @param employee 雇员参数
     * @return Message
     */
    @PostMapping(value = "/queryEmpWithId", produces = "application/json;charset=utf-8")
    public Message queryEmpWithId(@RequestBody Employee employee)
    {
        return Message.data(employeeService.queryEmpById(employee.getEmpId()));
    }

    /**
     * 通过Id查询雇员信息
     * @return Message
     */
    @PostMapping(value = "/queryEmpWithRedis", produces = "application/json;charset=utf-8")
    public Message queryEmpWithRedis()
    {
        List<Employee> emps = (List<Employee>)redisTemplate.opsForValue().get("emps");

        if (emps == null ){
            System.out.println("********************^_^********************");
            emps = employeeService.queryAllEmps();
            redisTemplate.opsForValue().set("emps",emps);
        }

        return Message.data(emps);
    }
}
