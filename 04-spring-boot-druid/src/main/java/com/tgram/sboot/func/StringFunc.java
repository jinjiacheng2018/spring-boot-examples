package com.tgram.sboot.func;

/**
 *<p> Description: 函数式接口:只有一个抽象方法的接口（functional interface）</p>
 *<p> Copyright: Copyright(c) 2018/12/26 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/26 17:43
 */
public interface StringFunc {

    /**
     * 字符串反转
     * @param string 入参字符串
     * @return 反转之后的字符串
     */
    String func(String string);

}
