package com.tgram.sboot.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *<p> Description: 定时任务类 </p>
 *<p> Copyright: Copyright(c) 2018/12/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/28 10:55
 */
@Component
public class ScheduldUtil {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("HelloWorld....");
    }
}
