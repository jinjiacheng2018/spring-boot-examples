package com.tgram.sboot;

import com.tgram.sboot.util.MyDateUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

/**
 *<p> Description: 日期测试类 </p>
 *<p> Copyright: Copyright(c) 2018/12/27 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/27 16:49
 */
@SpringBootTest
public class DateTest {

    /**
     * 计算连个日期之间相差的天数
     */
    @Test
    public void testBetweenDays(){
        // 日期字符串
        String dateStr1 = "2018-12-27";
        String dateStr2 = "2018-12-31";

        // 获取日期
        Date date1 = MyDateUtil.parseDate(dateStr1, "yyyy-MM-dd");
        Date date2 = MyDateUtil.parseDate(dateStr2, "yyyy-MM-dd");

        // 获取相差的天数
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        long timeInMillis1 = calendar.getTimeInMillis();
        calendar.setTime(date2);
        long timeInMillis2 = calendar.getTimeInMillis();

       long betweenDays =  (timeInMillis2 - timeInMillis1) / (1001*36001*241);
        System.out.println(betweenDays);
    }

    /**
     * 计算连个日期之间相差的天数
     */
    @Test
    public void testBetweenDays2(){
        // 日期字符串
        String dateStr1 = "2018-12-27 17:07:07";
        String dateStr2 = "2018-12-31 00:00:00";

        // 获取日期
        Date date1 = MyDateUtil.parseDate(dateStr1, "yyyy-MM-dd HH:mm:ss");
        Date date2 = MyDateUtil.parseDate(dateStr2, "yyyy-MM-dd HH:mm:ss");

        System.out.println(MyDateUtil.dateFormate(date1,"yyyy-MM-dd HH:mm:ss"));
        System.out.println(MyDateUtil.dateFormate(date2,"yyyy-MM-dd HH:mm:ss"));

        // 1s = 1000ms
        long betweenDays = (date2.getTime() - date1.getTime()) / (1000*3600*24);
        System.out.println(betweenDays);
    }

}
