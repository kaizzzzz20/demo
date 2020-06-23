package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/***
 *@Descroption: 响应给前端的信息
 *@Author: zhang.kai
 *@Date: 2020/6/2
 ***/
public class ServerResponse implements Serializable {

    private static final long serialVersionUID = -1632956782243534989L;

    private Integer status;

    private String message;

    private Object data;

    public ServerResponse() {
    }

    public ServerResponse(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return  this.status == ResponseCode.SUCCESS.getCode();
    }

    public static ServerResponse success(){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),null,null);
    }

    public static ServerResponse success(String message){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),message,null);
    }

    public static ServerResponse success(String message, Object data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),message,data);
    }

    public static ServerResponse error(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),null,null);
    }

    public static ServerResponse error(String message){
        return new ServerResponse(ResponseCode.ERROR.getCode(),message,null);
    }

    public static ServerResponse error(String message, Object data){
        return new ServerResponse(ResponseCode.ERROR.getCode(),message,data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
