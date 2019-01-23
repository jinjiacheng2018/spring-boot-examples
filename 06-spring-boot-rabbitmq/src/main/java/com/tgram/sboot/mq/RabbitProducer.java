package com.tgram.sboot.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *<p> Description: RabbitMQ消息生产者 </p>
 *<p> Copyright: Copyright(c) 2019/1/22 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/22 19:27
 */
public class RabbitProducer {

    private static final String EXCHANGE_NAME = "exchange_demo"; //交换机名称
    private static final String ROUNTING_KEY = "rountingkey_demo";
    private static final String QUEUE_NAME = "queue_demo"; //队列名称
    private static final String IP_ADDRESS = "118.31.7.33"; //IP地址
    private static final int PORT = 5672; //RabbitMQ服务端默认的端口5672

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory  =  new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);
        factory.setUsername("rabbitmq");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        System.out.println("connect: " + connection);
        //创建信道
        Channel channel = connection.createChannel();
        //创新一个type="direct"、吃就好的、非自动删除的交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true,false,null);
        //创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        //发送一条持久化的消息：HelloWorld!!!
        String message = "HelloWorld!!!";
        channel.basicPublish(EXCHANGE_NAME,ROUNTING_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        //关闭资源
        channel.close();
        connection.close();
    }
}
