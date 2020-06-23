package com.example.demo.config;

import com.example.demo.test.DealContext;
import com.example.demo.test.iface.DealStratege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/***
 *@Descroption: 测试策略模式
 *@Author: zhang.kai
 *@Date: 2020/6/22
 ***/
@Component
public class InjectionCollections {

    private static List<DealContext> dealContexts;

    @Autowired
    private List<DealStratege> dealStrateges;

    @PostConstruct
    void init(){
        dealContexts = new ArrayList<>();
        if(null ==  dealStrateges){
            return;
        }
        for(DealStratege dealStratege : dealStrateges){
            dealContexts.add(new DealContext(dealStratege.getClass().getName().toString(),dealStratege));
        }
    }

    public static void getDeal(String type){
        DealStratege dealStratege = null;
        for(DealContext dealContext : dealContexts){
            if(dealContext.options(type)){
                dealStratege = dealContext.getDeal();
                break;
            }
        }
        dealStratege.dealMethod(type);
    }

}
