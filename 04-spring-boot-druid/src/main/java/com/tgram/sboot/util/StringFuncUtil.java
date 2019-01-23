package com.tgram.sboot.util;

/**
 *<p> Description: 字符串工具类 </p>
 *<p> Copyright: Copyright(c) 2018/12/26 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/26 17:43
 */
public class StringFuncUtil
{
    
    /**
     * 实现字符串的反转
     * @param string 入参字符串
     * @return 反转之后的字符串
     */
    public static String reverseString(String string)
    {
        String resuleStr = "";
        for (int i = string.length() - 1; i >= 0; i--)
        {
            resuleStr += string.charAt(i);
        }
        
        return resuleStr;
    }
    
    /**
     * 打印乘法表
     * @param num1 数字1
     */
    public static void printMuliTable(int num1)
    {
        for (int i = 1; i <= num1; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println();
        }
    }
}
