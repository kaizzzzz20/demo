package com.example.demo.common;

/***
 *@Descroption: 常量.
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
public enum RedisConstant {

    EXPIRE_TIME_MINUTE(60);


    private Integer expireTime;

    RedisConstant(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

}
