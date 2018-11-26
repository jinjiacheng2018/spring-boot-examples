package com.tgram.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *<p> Description: Redis测试类 </p>
 *<p> Copyright: Copyright(c) 2018/11/26 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/26 22:25
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/redisIndex")
    public String redisIndex(){
        // 通过key获取value值
        String name = redisTemplate.opsForValue().get("name");

        return name;
    }

}
