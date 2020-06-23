package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/23
 ***/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodExcuteTime {

    String value() default "";
    String value2() default "";

}
