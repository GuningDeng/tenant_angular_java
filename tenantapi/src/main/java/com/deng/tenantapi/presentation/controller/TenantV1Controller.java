package com.deng.tenantapi.presentation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.aop.AutoLog;
import com.deng.tenantapi.application.dto.TenantDto;
import com.deng.tenantapi.application.service.implement.TenantService;
import com.deng.tenantapi.domain.Tenant;
import com.deng.tenantapi.domain.enums.AutoLogEnum;
import com.deng.tenantapi.domain.enums.AutoLogOperateEnum;
import com.deng.tenantapi.infrastructure.repository.TenantRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("tenant/v1")
public class TenantV1Controller {
    private final TenantService tenantService;
    

    public TenantV1Controller(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @AutoLog(value = "interface get tenants", logType = AutoLogEnum.LOG_TYPE_2, operateType = AutoLogOperateEnum.OPERATE_TYPE_1)
    @GetMapping("tenants")
    public List<Tenant> getTenants() {
        List<Tenant> tenants = tenantService.findTenants();
        return tenants;
    }

    @GetMapping("tenants/{id}")
    public Tenant getTenantById(@PathVariable Long id) {
        Tenant tenant = tenantService.findTenantByid(id).orElseThrow(() -> new RuntimeException("tenant not found"));
        return tenant;
    }

    @GetMapping("tenants/byMobileClient/{mobile}")
    public TenantDto getTenantDtoByMobile(@PathVariable String mobile) {
        TenantDto tenantDto = tenantService.findTenantDtoByMobile(mobile);

        return tenantDto;
    }  
    
    @GetMapping("tenants/byMobile/{mobile}")
    public Tenant getTenantByMobile(@PathVariable String mobile) {
        Tenant tenant = tenantService.findByMobile(mobile);
        return tenant;
    }
        
}
