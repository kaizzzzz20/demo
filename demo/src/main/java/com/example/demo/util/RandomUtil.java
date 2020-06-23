package com.example.demo.util;

import java.util.UUID;

/***
 *@Descroption: UUID工具
 *@Author: zhang.kai
 *@Date: 2020/6/3
 ***/
public class RandomUtil {

    public static String UID32(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(RandomUtil.UID32());

    }


}
