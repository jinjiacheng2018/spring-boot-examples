package com.tgram.sboot.controller;

import com.tgram.sboot.rabbit.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *<p> Description: 控制层 </p>
 *<p> Copyright: Copyright(c) 2019/1/23 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/23 9:28
 */
@RestController
public class HelloMqController {

    @Autowired
    private HelloSender helloSender;

    /**
     * 测试发送消息
     * @return HelloSender
     */
    @RequestMapping(value = "/helloMq")
    public String helloMq()
    {
        //发送消息
        helloSender.send();
        return "Hello,RabbitMQ!!!";
    }

}
