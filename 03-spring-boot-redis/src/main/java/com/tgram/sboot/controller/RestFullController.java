package com.tgram.sboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSONObject;
import com.tgram.sboot.core.Message;
import com.tgram.sboot.entity.Employee;
import com.tgram.sboot.service.EmployeeService;

/**
 *<p> Description: RestFull请求风格的控制层 </p>
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

    /**
     * 注意：注意RedisTemplate对象只能写：RedisTemplate<Object, Object> 、 RedisTemplate<String, String>
     */
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 测试Rest风格的方法
     * @return
     */
    @RequestMapping("/restFullIndex/{empId}")
    public Message restFullRequest(@PathVariable(value = "empId") Integer empId)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("emp",employeeService.queryEmpById(empId));

        return Message.data(jsonObject);
    }

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
     * 通过Id查询雇员信息并使用Redis缓存(key会自动序列化)
     * @return Message
     */
    @PostMapping(value = "/queryEmpWithRedis", produces = "application/json;charset=utf-8")
    public Message queryEmpWithRedis()
    {
        // 自定义对象要存入缓存中必须实现Serializable接口，否则会报错
        List<Employee> emps = (List<Employee>)redisTemplate.opsForValue().get("emps");

        if (emps == null ){
            System.out.println("********************^_^********************");
            emps = employeeService.queryAllEmps();
            redisTemplate.opsForValue().set("emps",emps);
        }

        return Message.data(emps);
    }

    /**
     * 通过Id查询雇员信息并使用Redis缓存(key自定序列化器)
     * @return Message
     */
    @PostMapping(value = "/queryEmpWithRedisKeySerializable", produces = "application/json;charset=utf-8")
    public Message queryEmpWithRedisKeySerializable()
    {
        // 自定义序列化器(字符串的序列化器)，并设置
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        // 自定义对象要存入缓存中必须实现Serializable接口，否则会报错
        List<Employee> emps = (List<Employee>)redisTemplate.opsForValue().get("allemps");

        if (emps == null ){
            System.err.println("********************^_^********************");
            emps = employeeService.queryAllEmps();
            redisTemplate.opsForValue().set("allemps",emps);
        }

        return Message.data(emps);
    }
}
