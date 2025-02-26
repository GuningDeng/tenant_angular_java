package com.deng.tenantapi.application.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.deng.tenantapi.application.aop.AutoLog;

@Component
@Aspect
public class AutoLogAspect {
    @Pointcut("@annotation(com.deng.tenantapi.application.aop.AutoLog)")
    public void logPointCut(){

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        System.out.println("request received");

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        AutoLog autoLog = method.getAnnotation(AutoLog.class);

        System.out.println("[Around notification]: [Log type] : " + autoLog.logType().getType() + 
        ", [Operation type] : " + autoLog.operateType().getType() + ", [Log type] :" + autoLog.value());
        // execute
        Object result = point.proceed();

        System.out.println("execution completed...");

        System.out.println("[Around notification]: execution result: " + result.toString());

        long time = System.currentTimeMillis() - beginTime;

        System.out.println("execution time: " + time + "ms");

        // return result.toString().concat(" added content to aspect");
        return result;

    }
}
