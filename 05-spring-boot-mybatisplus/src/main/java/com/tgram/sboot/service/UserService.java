package com.tgram.sboot.service;

import com.tgram.sboot.eneity.User;

import java.util.List;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/9 15:40
 */
public interface UserService{

    /**
     * 查询所有的用户
     * @return List<User>
     */
    List<User> queryAllUsers();
}
