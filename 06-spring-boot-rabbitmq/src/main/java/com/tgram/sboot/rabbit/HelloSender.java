package com.tgram.sboot.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *<p> Description: RabbitMQ消息发送者 </p>
 *<p> Copyright: Copyright(c) 2019/1/22 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/22 18:28
 */
@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 像指定的队列发送消息
     */
    public void send()
    {
        String context = "Hello RabbitMQ," + new Date();
        System.out.println("Sender: " + context);
        rabbitTemplate.convertAndSend("queueFirst",context);
    }
}
