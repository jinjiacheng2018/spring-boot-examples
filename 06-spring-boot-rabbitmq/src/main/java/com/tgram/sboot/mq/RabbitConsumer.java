package com.tgram.sboot.mq;

import com.rabbitmq.client.*;

import javax.xml.stream.FactoryConfigurationError;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *<p> Description: RabbitMQ消息消费者 </p>
 *<p> Copyright: Copyright(c) 2019/1/22 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/22 19:53
 */
public class RabbitConsumer {

    private static final String QUEUE_NAME = "queue_demo"; //队列名称
    private static final String IP_ADDRESS = "118.31.7.33"; //IP地址
    private static final int PORT = 5672; //RabbitMQ服务端默认的端口5672

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
          new Address(IP_ADDRESS,PORT)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("rabbitmq");
        factory.setPassword("123456");
        //区分服务端与客户端的连接方式
        Connection connection = factory.newConnection(addresses);
        //创建信道
        final Channel channel = connection.createChannel();
        //设置客户端最多接收未被ack的消息格式
        channel.basicQos(64);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(QUEUE_NAME,consumer);
        //等待回调函数执行完毕，关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
        System.out.println("------end------");
    }
}
