package com.tgram.sboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *<p> Description: 自定义Filter,使用@WebFilter注解自动注入Filter，在主启动类添加@ServletComponentScan扫面包 </p>
 *<p> Copyright: Copyright(c) 2019/1/24 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2019/1/24 14:46
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("MyFilter's init method...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String realPath = request.getRequestURL().toString();
        System.err.println("------> realPath: " + realPath);

        //过滤放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.err.println("MyFilter's init destroy...");
    }
}
