package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *@Descroption: 保证接口幂等性的注解
 *@Author: zhang.kai
 *@Date: 2020/6/2
 ***/
@Target(ElementType.METHOD)  //说明注解的范围是在方法上
@Retention(RetentionPolicy.RUNTIME)  //说明注解的生命周期
public @interface ApiIdempotent {


}
