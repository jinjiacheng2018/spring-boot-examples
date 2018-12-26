package com.tgram.sboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *<p> Description: 日期工具类 </p>
 *<p> Copyright: Copyright(c) 2018/12/26 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/26 11:06
 */
public class MyDateUtil {

    /**
     * 将指定的日期字符串转换成日期
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return 日期对象
     */
    public static Date parseDate(String dateStr, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw  new RuntimeException("日期转化错误");
        }

        return date;
    }

    /**
     * 将指定的日期格式化成指定的日期字符串
     * @param date 日期对象
     * @param pattern 格式
     * @return 格式化后的日期字符串
     */
    public static String dateFormate(Date date, String pattern)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr;
        if(date == null)
        {
            return "";
        }
        dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 查询指定一起的前后指定的天数
     * @param date 日期对象
     * @param days 天数
     * @return 日期对象
     */
    public static Date incr(Date date, int days)
    {
        if (date == null){
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }
}
