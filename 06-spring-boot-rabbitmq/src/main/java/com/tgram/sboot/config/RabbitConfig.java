package com.tgram.sboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *<p> Description: RabbitMQ队列配置类 </p>
 *<p> Copyright: Copyright(c) 2019/1/22 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/22 18:18
 */
@Configuration
public class RabbitConfig {

    /**
     * 配置Bean示例
     * @return Queue
     */
    @Bean
    public Queue Queue()
    {
        return  new Queue("queueFirst");
    }
}
