package com.example.demo.common;

/***
 *@Descroption: 响应的状态码
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
public enum ResponseCode {

    SUCCESS(0,"操作成功"),
    ERROR(1,"操作失败"),
    SERVER_ERROR(500,"服务器异常"),
    ERROR_COMMIT(10001,"错误的提交"),
    REPEAT_COMMIT(10002,"重复的提交");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
