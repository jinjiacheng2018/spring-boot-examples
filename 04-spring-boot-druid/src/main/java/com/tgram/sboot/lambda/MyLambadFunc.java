package com.tgram.sboot.lambda;

import com.tgram.sboot.func.LambdaFunc;
import com.tgram.sboot.func.StringFunc;

/**
 *<p> Description: 函数工具类 </p>
 *<p> Copyright: Copyright(c) 2018/12/26 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/26 17:52
 */
public class MyLambadFunc {

    /**
     * 函数方法的实现
     * @param stringFunc 函数式接口类
     * @param string 入参字符串
     * @return 反转之后的字符串
     */
    public static String resverseStringFunc(StringFunc stringFunc,String string){
        return stringFunc.func(string);
    }

    /**
     * 打印乘法表
     * @param lambdaFunc 函数式接口对象
     * @param num1 数字1
     */
    public static void printTable(LambdaFunc lambdaFunc,int num1){
        lambdaFunc.printTable(num1);
    }
}
