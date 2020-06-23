package com.example.demo.test;

import com.example.demo.test.iface.DealStratege;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/22
 ***/
public class DealContext {

    private String type;

    private DealStratege dealStratege;

    public DealContext(String type, DealStratege dealStratege) {
        this.type = type;
        this.dealStratege = dealStratege;
    }

    public DealStratege getDeal() {
        return dealStratege;
    }

    public boolean options(String type){
        return this.type.equals(type);
    }

}
