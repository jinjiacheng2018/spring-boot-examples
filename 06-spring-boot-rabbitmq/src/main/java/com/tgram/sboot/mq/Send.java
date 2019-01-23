package com.tgram.sboot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("118.31.7.33");
//        factory.setUsername("rabbitmq");
//        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", false, false, false, null);
        channel.basicPublish("", "hello", null, "你好".getBytes("UTF-8"));
        channel.close();
        connection.close();
    }
}
