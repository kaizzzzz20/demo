package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/23
 ***/
@Aspect
public class MethodExcuteTimeAspect {


    @Pointcut("execution(@com.example.demo.annotation.MethodExcuteTime * *(..))")
    public void methodAnnotationWithExcuteTime(){ }

    @Around("methodAnnotationWithExcuteTime()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable{


        return null;
    }














}
