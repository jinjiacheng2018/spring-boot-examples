package com.tgram.sboot.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *<p> Description: 描述信息 </p>
 *<p> Copyright: Copyright(c) 2019/1/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/9 15:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId; //编号

    private String userName; //姓名

    private Integer userAge; //年龄

    private String userEmail; //邮箱
}
