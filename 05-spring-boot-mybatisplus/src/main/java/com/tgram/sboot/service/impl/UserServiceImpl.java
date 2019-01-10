package com.tgram.sboot.service.impl;

import com.tgram.sboot.eneity.User;
import com.tgram.sboot.mapper.UserMapper;
import com.tgram.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/9 15:42
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    /**
     * 查询所有的用户信息
     * @return List<User>
     */
    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectList(null);
    }
}
