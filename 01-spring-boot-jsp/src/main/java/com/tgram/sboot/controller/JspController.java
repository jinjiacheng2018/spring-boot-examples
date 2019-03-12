package com.tgram.sboot.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class JspController {

    @RequestMapping(value = "/success")
    public String index(Model model){
        model.addAttribute("msg","Hello,SpringBoot-JSP");
        return "success";
    }

    public static void main(String[] args) {
        Boolean i1 = true;
        Boolean i2 = true;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        System.out.println("--------------");

        Integer i3 = 100;   // i3=128
        Integer i4 = 100;   // i4=128
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));
    }
}
