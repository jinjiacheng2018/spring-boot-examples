package com.tgram.sboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tgram.sboot.core.Message;

/**
 *<p> Description: RestFull风格的控制层 </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 15:42
 */
@RestController
public class RestFullController {

    @RequestMapping("/restFullIndex")
    public String restFullIndex(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Tom");
        jsonObject.put("age",20);
        jsonObject.put("address","XiangYang");

        return Message.data(jsonObject).toJson();
    }

}
