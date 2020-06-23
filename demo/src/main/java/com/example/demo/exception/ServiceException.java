package com.example.demo.exception;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 839187393204305967L;
    private String code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
