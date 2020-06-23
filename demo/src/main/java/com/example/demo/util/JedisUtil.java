package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Component
public class JedisUtil {

    @Autowired
    private JedisPool jedisPool;
    private static  final Logger logger = LoggerFactory.getLogger(JedisUtil.class.getName());

    private Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 设值
     * @param key
     * @param value
     * @return
     * **/
    public String set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.set(key, value);
        }catch (Exception e){
            logger.error("set key {} , value {} error",key,value,e);
            return null;
        }finally {
            close(jedis);
        }
    }

    /**
     * @param key
     * @param value
     * @param expireTime  设置过期时间,单位s
     * @return
     * **/
    public String set(String key,String value,int expireTime){
        Jedis jedis = null;
        try {
            jedis=getJedis();
            return jedis.setex(key,expireTime,value);
        }catch (Exception e){
            logger.error("set key:{} expireTime:{} value:{} error",key,expireTime,value);
            return null;
        }finally {
            close(jedis);
        }
    }


    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.get(key);
        }catch (Exception e){
            logger.error("get key {} error",key,e);
            return null;
        }finally {
            close(jedis);
        }
    }

    public Long delete(String key){
        Jedis jedis =null;
        try {
            jedis = getJedis();
            return jedis.del(key);
        }catch (Exception e){
            return null;
        }finally {
            close(jedis);
        }
    }



    /***
     * @param key
     * @return
     * **/
    public Boolean exists(String key){
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.exists(key);
        }catch (Exception e){
            return null;
        }finally {
           close(jedis);
        }



    }



    private void close(Jedis jedis) {
        if(null != jedis){
            jedis.close();
        }



    }


}
