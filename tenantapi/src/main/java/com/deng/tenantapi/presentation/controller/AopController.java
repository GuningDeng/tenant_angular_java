package com.deng.tenantapi.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.aop.AutoLog;
import com.deng.tenantapi.application.aop.NoRepeatSubmit;
import com.deng.tenantapi.application.utils.RedisUtil;
import com.deng.tenantapi.domain.enums.AutoLogEnum;
import com.deng.tenantapi.domain.enums.AutoLogOperateEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/aop")
public class AopController {
    private final RedisUtil redisUtil;
    public AopController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }
    
    @AutoLog(value = "interface test", logType = AutoLogEnum.LOG_TYPE_2, operateType = AutoLogOperateEnum.OPERATE_TYPE_1)
    @GetMapping("/aopTest")
    public String aopTest() {
        return "aop test:";
    }

    /**
     * test redis, prevent continuous requests in a short period of time
     * @param key
     * @param value
     * @return
     */
    @NoRepeatSubmit
    @GetMapping("/set")
    public boolean redisSet(String key, String value) {
        System.out.println(key + "--|--" + value);
        // return redisUtil.set(key, value) ? "success" : "fail";
        return redisUtil.set(key, value);
    }
    
}
