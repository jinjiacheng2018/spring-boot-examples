package com.tgram.sboot;

import com.tgram.sboot.eneity.User;
import com.tgram.sboot.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
}
