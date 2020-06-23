package com.example.demo.test.impl;

import com.example.demo.test.iface.DealStratege;
import org.springframework.stereotype.Component;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/22
 ***/
@Component
public class DealOne implements DealStratege {

    @Override
    public void dealMethod(String option) {
        System.out.println(DealOne.class.getName()+ ": excuted!!!");
    }
}
