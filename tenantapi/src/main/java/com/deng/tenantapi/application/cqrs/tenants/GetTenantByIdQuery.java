package com.deng.tenantapi.application.cqrs.tenants;

import com.deng.tenantapi.application.dto.TenantDetailDto;
// import com.deng.tenantapi.domain.Tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTenantByIdQuery {
    private Long id;
    private TenantDetailDto tenant;
}
