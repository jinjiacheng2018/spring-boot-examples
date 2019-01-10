package com.tgram.sboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.tgram.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/9 15:45
 */
@RestController
public class UserController
{
    
    @Autowired
    private UserService userService;

    /**
     * 查询所有的员工接口
     * @return JSONObject
     */
    @RequestMapping("/allUsers")
    public JSONObject allUsers()
    {
        JSONObject renObj = new JSONObject();
        renObj.put("users",userService.queryAllUsers());
        return renObj;
    }
    
}
