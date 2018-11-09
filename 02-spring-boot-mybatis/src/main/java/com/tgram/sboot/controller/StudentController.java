package com.tgram.sboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tgram.sboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *<p> Description: 控制层 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:22
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/allStuds")
    public JSONObject allStuds(){
        // 查询所有的学生信息已json的格式返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stuList",studentService.allStudentsList());
        return jsonObject;
    }

}
