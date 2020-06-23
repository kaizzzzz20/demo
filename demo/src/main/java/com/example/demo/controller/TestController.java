package com.example.demo.controller;

import com.example.demo.annotation.ApiIdempotent;
import com.example.demo.common.ServerResponse;
import com.example.demo.config.InjectionCollections;
import com.example.demo.service.TokenService;
import com.example.demo.test.impl.DealOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/token")
    public ServerResponse getToken(){
        return tokenService.createToken();
    }


    /***
     * 测试表单提交幂等性
     * **/
    @ApiIdempotent
    @RequestMapping(value = "/ts",method = RequestMethod.GET)
    public ServerResponse testIdempotence(){


        return ServerResponse.success("testIdempotence: success");
    }

    @GetMapping("/injection")
    void TestInjectionsUserDefine(){
        InjectionCollections.getDeal(DealOne.class.getName().toString());
    }


}
