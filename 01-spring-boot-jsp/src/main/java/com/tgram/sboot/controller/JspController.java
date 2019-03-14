package com.tgram.sboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *<p> Description: 页面个跳转控制层 </p>
 *<p> Copyright: Copyright(c) 2018/11/7 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/7 19:37
 */
@Controller
public class JspController
{
    
    @RequestMapping(value = "/success")
    public String index(Model model)
    {
        model.addAttribute("msg", "Hello,SpringBoot-JSP");
        return "success";
    }
}
