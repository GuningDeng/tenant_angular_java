package com.deng.tenantapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.domein.Tenant;
import com.deng.tenantapi.repository.TenantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin
@RestController
@RequestMapping("tenant/v1")
public class TenantV1Controller {
    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping("tenants")
    public List<Tenant> getTenants() {
        List<Tenant> tenants = tenantRepository.findAll();
        return tenants;
    }
    
}
