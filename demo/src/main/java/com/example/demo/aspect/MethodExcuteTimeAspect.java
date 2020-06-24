package com.example.demo.aspect;

import com.example.demo.annotation.MethodExcuteTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/***
 *@Descroption:
 *@Author: zhang.kai
 *@Date: 2020/6/23
 ***/
@Aspect
@Slf4j
@Component
public class MethodExcuteTimeAspect {


    @Pointcut("@annotation(com.example.demo.annotation.MethodExcuteTime)")
    public void methodAnnotationWithExcuteTime(){ }

    @Around("methodAnnotationWithExcuteTime()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable{

        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        String funName =  methodSignature.getMethod().getAnnotation(MethodExcuteTime.class).value();

        //
        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long durationTime = System.currentTimeMillis() - begin;


        log.info(String.format("%s的切面,%s类的%s方法执行了,用时%d ms", funName,className,methodName,durationTime));

        return result;
    }

}
