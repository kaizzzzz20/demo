package com.example.demo.service.impl;

import com.example.demo.common.RedisConstant;
import com.example.demo.common.ResponseCode;
import com.example.demo.common.ServerResponse;
import com.example.demo.exception.ServiceException;
import com.example.demo.service.TokenService;
import com.example.demo.util.JedisUtil;
import com.example.demo.util.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
@Service
public class TokenServiceImpl implements TokenService {
    private static final String TOKEN_PREFIX = "token: ";
    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ServerResponse createToken() {
        String uid = RandomUtil.UID32();
        StringBuilder token = new StringBuilder();
        token.append(TOKEN_PREFIX).append(uid);
        jedisUtil.set(uid,token.toString(), RedisConstant.EXPIRE_TIME_MINUTE.getExpireTime()*5);
        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if(StringUtils.isBlank(token)){ //如果header中不包含token
            token = request.getParameter(TOKEN_NAME);
            if(StringUtils.isBlank(token)){ //param中也不包含token
                throw new ServiceException(ResponseCode.ERROR_COMMIT.getMsg());
            }
        }

        if(!jedisUtil.exists(token)){
            throw new ServiceException("打印啊啊啊 ");
            //throw new ServiceException(ResponseCode.REPEAT_COMMIT.getMsg());
        }

        Long del = jedisUtil.delete(token);
        if(del<=0){
            throw new ServiceException(ResponseCode.REPEAT_COMMIT.getMsg());
        }

    }
}
