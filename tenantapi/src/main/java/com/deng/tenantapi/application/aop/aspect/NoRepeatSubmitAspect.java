package com.deng.tenantapi.application.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.deng.tenantapi.application.aop.NoRepeatSubmit;
import com.deng.tenantapi.application.utils.HttpContextUtil;
import com.deng.tenantapi.application.utils.RedisUtil;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class NoRepeatSubmitAspect {
    private final RedisUtil redisUtil;

    public NoRepeatSubmitAspect(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Around("@annotation(noRepeatSubmit)")
    public Object around(ProceedingJoinPoint point, NoRepeatSubmit noRepeatSubmit) throws Throwable {
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        
        // Get the request URL and token
        String url = request.getRequestURL().toString();
        String token = request.getHeader("Authorization");
        
        // Create a unique key for Redis
        String redisKey = String.format("%s:%s", url, token);
        
        // Check if the request is already in Redis
        if (redisUtil.hasKey(redisKey)) {
            throw new RuntimeException("Please do not submit repeatedly!");
        }
        
        // If not in Redis, proceed with the request and store in Redis with expiration
        boolean isSuccess = redisUtil.set(redisKey, true, noRepeatSubmit.lockTime());
        if (!isSuccess) {
            throw new RuntimeException("Redis operation failed");
        }
        
        // Execute the actual method
        return point.proceed();
    }
}
