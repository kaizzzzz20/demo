package com.example.demo.test.impl;

import com.example.demo.test.iface.DealStratege;
import org.springframework.stereotype.Component;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/22
 ***/
@Component
public class DealTwo implements DealStratege {
    @Override
    public void dealMethod(String option) {
        System.out.println(DealTwo.class.getName() + ": excuted!!!!");
    }
}
