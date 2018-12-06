package com.tgram.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootRedisApplication
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}
