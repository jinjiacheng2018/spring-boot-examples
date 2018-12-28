package com.tgram.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DruidApplication
{
    
    public static void main(String[] args)
    {
        SpringApplication.run(DruidApplication.class, args);
    }
    
}
