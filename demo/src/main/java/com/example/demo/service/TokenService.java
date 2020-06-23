package com.example.demo.service;

import com.example.demo.common.ServerResponse;

import javax.servlet.http.HttpServletRequest;

/***
 *@Descroption: token接口
 *@Author: zhang.kai
 *@Date: 2020/6/2
 ***/
public interface TokenService {

    ServerResponse createToken();

    void checkToken(HttpServletRequest request);

}
