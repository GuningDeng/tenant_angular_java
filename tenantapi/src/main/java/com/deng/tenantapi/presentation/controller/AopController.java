package com.deng.tenantapi.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.aop.AutoLog;
import com.deng.tenantapi.domain.enums.AutoLogEnum;
import com.deng.tenantapi.domain.enums.AutoLogOperateEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/aop")
public class AopController {
    
    @AutoLog(value = "interface test", logType = AutoLogEnum.LOG_TYPE_2, operateType = AutoLogOperateEnum.OPERATE_TYPE_1)
    @GetMapping("/aopTest")
    public String aopTest() {
        return "aop test:";
    }
    
}
