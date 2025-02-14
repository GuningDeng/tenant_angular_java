package com.deng.tenantapi.application.cqrs.tenants;

import com.deng.tenantapi.application.dto.TenantDetailDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTenantCommand {
    private TenantDetailDto tenant;
}
