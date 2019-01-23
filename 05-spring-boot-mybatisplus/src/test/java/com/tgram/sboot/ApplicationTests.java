package com.tgram.sboot;

import com.tgram.sboot.eneity.User;
import com.tgram.sboot.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 使用MyBatis-Plus测试查询数据
     */
    @Test
    public void test1()
    {
        System.out.println("-------SELECT ALL USERS METHOD------");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.err::println);
    }

    /**
     * 获取对象的类型
     * @param o 对象
     * @return 类型字符串
     */
    public String getType(Object o)
    {
        return o.getClass().toString();
    }

    /**
     * 测试获取对象的类型
     */
    @Test
    public void test2(){
        User user = new User(1,"Tom",20,"tom@qq.com");
        Integer num = 0;
        System.out.println(getType(user));
    }

    @Test
    public void test3(){
        short s1 = 1;
        // s1 = s1 + 1; //报错，类型转换有问题
        s1 += 1; //等价于：s1 = (short)(s1 + 1);所以不报错
    }

    /**
     * 判断字符串是否是数字
     */
    @Test
    public void testIsNum(){
        String str = "123244你好3";
        Pattern pattern = Pattern.compile("[0-9]+$");
        boolean matches = pattern.matcher(str).matches();
        System.out.println(str + "字符串是否纯数字：" + (matches ? "✔" : "✖"));
    }

    /**
     * 判断字符串是否是数字
     */
    @Test
    public void testIsNum2(){
        String str = "15312345678";
        Pattern pattern = Pattern.compile("([1][3][5]|[1][5][3])[0-9]{8}");
        boolean matches = pattern.matcher(str).matches();
        System.out.println(str + "电话号码是否合法：" + (matches ? "✔" : "✖"));
    }

}
