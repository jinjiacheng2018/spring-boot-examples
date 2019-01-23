package com.tgram.sboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *<p> Description: RabbitMQ消息接收者,@RabbitListener注解指定监听的队列 </p>
 *<p> Copyright: Copyright(c) 2019/1/22 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/22 18:51
 */
@Component
@RabbitListener(queues = "queueFirst")
public class HelloReceiver {

    /**
     * 处理接收的消息
     * @param hello 消息
     */
    @RabbitHandler
    public void process(String hello)
    {
        System.out.println("Receiver: " + hello);
    }
}
