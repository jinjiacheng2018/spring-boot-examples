package com.tgram.sboot.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

/**
 *<p> Description: 返回数据类(7qb公司接口返回的数据封装类) </p>
 *<p> Copyright: Copyright(c) 2018/11/28 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/11/28 15:44
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message<T> {

    private static Logger logger = LoggerFactory.getLogger(Message.class);

    private String code;
    private T data;
    private String msg = "";
    private String exception;
    private Integer status = 1;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Message.logger = logger;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static Message message(String msg){
        Message message = new Message();
        Environment env = SpringUtil.getBean(Environment.class);
        message.setMsg(env.getProperty(msg));
        return message;
    }

    public static <T> Message<T> data(T data){
        Message<T> message = new Message<T>();
        message.setData(data);
        return message;
    }

    public String toJson(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
            return "";
        }
    }
}
