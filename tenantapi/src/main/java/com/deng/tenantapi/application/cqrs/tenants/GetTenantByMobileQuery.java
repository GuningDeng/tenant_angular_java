package com.deng.tenantapi.application.cqrs.tenants;

import com.deng.tenantapi.application.dto.TenantDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTenantByMobileQuery {
    private String mobile;
    private TenantDto tenantDto;
    
}
