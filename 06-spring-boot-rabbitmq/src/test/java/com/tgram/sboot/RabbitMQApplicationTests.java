package com.tgram.sboot;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tgram.sboot.rabbit.HelloSender;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQApplicationTests
{

    @Autowired
    private HelloSender helloSender;

    /**
     * 测试发送消息
     */
    @Test
    public void testSender()
    {
        helloSender.send();
    }

    /**
     * 测试连接RabbitMQ
     */
    @Test
    public void testRabbitConnect() throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory  =  new ConnectionFactory();
        factory.setHost("118.31.7.33");
        factory.setPort(5672);
        factory.setUsername("rabbitmq");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        System.out.println(connection);

    }
    
}
