package com.tgram.sboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tgram.sboot.eneity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *<p> Description: Mapper层继承BaseMapper </p>
 *<p> Copyright: Copyright(c) 2019/1/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/9 15:26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
