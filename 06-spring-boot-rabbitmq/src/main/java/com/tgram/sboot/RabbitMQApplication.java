package com.tgram.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *<p> Description: 主启动类，注入自定义filte需要在主启动类添加@ServletComponentScan来扫描过滤器所在的包 </p>
 *<p> Copyright: Copyright(c) 2019/1/24 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/24 14:53
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.tgram.sboot.filter"})
public class RabbitMQApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(RabbitMQApplication.class, args);
    }

}
