package com.deng.tenantapi.presentation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.cqrs.tenants.GetAllTenantsQueryHandler;
import com.deng.tenantapi.application.cqrs.tenants.GetTenantByIdQuery;
import com.deng.tenantapi.application.cqrs.tenants.GetTenantByIdQueryHandler;
import com.deng.tenantapi.application.cqrs.tenants.GetTenantByMobileQuery;
import com.deng.tenantapi.application.cqrs.tenants.GetTenantByMobileQueryHandler;
import com.deng.tenantapi.application.dto.TenantDetailDto;
import com.deng.tenantapi.application.dto.TenantDto;

@CrossOrigin
@RestController
@RequestMapping("tenant/v3")
public class TenantV3QueriesController {
    private final GetAllTenantsQueryHandler getAllTenantsQueryHandler;
    private final GetTenantByIdQueryHandler getTenantByIdQueryHandler;
    private final GetTenantByMobileQueryHandler getTenantByMobileQueryHandler;
    public TenantV3QueriesController(GetAllTenantsQueryHandler getAllTenantsQueryHandler,
            GetTenantByIdQueryHandler getTenantByIdQueryHandler,
            GetTenantByMobileQueryHandler getTenantByMobileQueryHandler) {
        this.getAllTenantsQueryHandler = getAllTenantsQueryHandler;
        this.getTenantByIdQueryHandler = getTenantByIdQueryHandler;
        this.getTenantByMobileQueryHandler = getTenantByMobileQueryHandler;
    }

      
    @GetMapping("tenants")
    public List<TenantDetailDto> getTenants() {
        
        List<TenantDetailDto> tenants = getAllTenantsQueryHandler.handle(null);
        return tenants;
    }

    @GetMapping("tenants/{id}")
    public TenantDetailDto getTenantById(@PathVariable Long id) {
        GetTenantByIdQuery query = new GetTenantByIdQuery();
        query.setId(id);
        TenantDetailDto tenant = getTenantByIdQueryHandler.handle(query);
        return tenant;
    }

    @GetMapping("tenants/byMobile/{mobile}")
    public TenantDto getTenantDtoByMobile(@PathVariable String mobile) {
        GetTenantByMobileQuery query = new GetTenantByMobileQuery();
        query.setMobile(mobile);
        TenantDto tenantDto = getTenantByMobileQueryHandler.handle(query);

        return tenantDto;
    }
}
