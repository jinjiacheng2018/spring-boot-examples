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

@RunWith(SpringRunner.class)
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
    
}
