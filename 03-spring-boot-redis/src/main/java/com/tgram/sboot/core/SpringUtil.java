package com.tgram.sboot.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *<p> Description: Spring的工具类  </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 15:56
 */
public class SpringUtil implements ApplicationContextAware
{

    private static ApplicationContext context;

    public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz){
        return (T) context.getBean(clazz);
    }

    public static void setContext(ApplicationContext context) {
        SpringUtil.context = context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 添加一个setter方法，绕过FindBugs的错误检查
        // this.context = applicationContext;
       setContext(applicationContext);
    }
}
