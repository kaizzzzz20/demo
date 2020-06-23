package com.example.demo.test;

import com.example.demo.test.iface.DealStratege;
import com.example.demo.test.impl.DealOne;
import com.example.demo.test.impl.DealTwo;

import java.util.ArrayList;
import java.util.List;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/22
 ***/
public class TestDeal {

    private static List<DealContext> dealContexts = new ArrayList<>();
    static {
        dealContexts.add(new DealContext("1",new DealOne()));
        dealContexts.add(new DealContext("2",new DealTwo()));
    }

    public void excuteDeal(String type){
        DealStratege dealStratege = null;
        for (DealContext ds :dealContexts){
            if(ds.options(type)){
                dealStratege = ds.getDeal();
                break;
            }
        }

        dealStratege.dealMethod(type);
    }


    public static void main(String[] args) {

        TestDeal testDeal = new TestDeal();
        testDeal.excuteDeal("1");


    }




}
