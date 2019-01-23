package com.tgram.sboot.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.tgram.sboot.entity.Student;
import com.tgram.sboot.service.StudentService;
import com.tgram.sboot.uitl.ExportExcelUtil;

/**
 *<p> Description: 控制层 </p>
 *<p> Copyright: Copyright(c) 2018/11/9 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/9 14:22
 */
@RestController
public class StudentController
{
    
    @Resource
    private StudentService studentService;
    
    @RequestMapping("/allStuds")
    public JSONObject allStuds()
    {
        // 查询所有的学生信息已json的格式返回
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stuList", studentService.allStudentsList());
        return jsonObject;
    }
    
    /**
     * 将所有的学生信息到处到excel表格中
     * @param response
     */
    @RequestMapping("/allStudsExportExcle")
    public void allStudsExportExcle(HttpServletResponse response) throws IOException
    {
        // 设置请求头信息(使用String防止文件名中文乱码)
        response.setHeader("Content-Disposition","attachment;filename=" + new String("学生信息表.xls".getBytes(),"ISO-8859-1"));
        // response.setHeader("Content-disposition", "attachment; filename=student.xls");
        
        // 获取输入流信息
        OutputStream outputStream = response.getOutputStream();
        
        // 获取数据并封装数据
        List<List<String>> dataList = new ArrayList<>();
        List<String> headList = Arrays.asList("学生编号", "学生姓名", "学生年龄");
        dataList.add(headList);

        // 获取数据
        List<Student> students = studentService.allStudentsList();
        students.forEach(student -> {
            List<String> rowList = new ArrayList<>();
            rowList.add(student.getStu_id() + "");
            rowList.add(student.getStu_name() + "");
            rowList.add(student.getStu_age() + "");
            dataList.add(rowList);
        });

        // 调用工具类到处Excel表格
        ExportExcelUtil.exportExcel(dataList,outputStream,false);

        // 刷新输出流
        outputStream.flush();
    }
    
}
