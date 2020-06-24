package com.example.demo.controller;

import com.example.demo.annotation.ApiIdempotent;
import com.example.demo.annotation.MethodExcuteTime;
import com.example.demo.common.ServerResponse;
import com.example.demo.config.InjectionCollections;
import com.example.demo.service.TokenService;
import com.example.demo.test.impl.DealOne;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

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
    @MethodExcuteTime(value = "注入controller测试")
    void TestInjectionsUserDefine(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InjectionCollections.getDeal(DealOne.class.getName().toString());
    }

    @GetMapping("notnull")
    @ResponseBody
    public User testNotNull(@NotNull @RequestParam("value")String value){

        return new User(value,"1234","18511111111");
    }


}
