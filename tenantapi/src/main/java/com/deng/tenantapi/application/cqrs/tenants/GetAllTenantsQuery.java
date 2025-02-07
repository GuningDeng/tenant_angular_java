package com.deng.tenantapi.application.cqrs.tenants;

import java.util.List;

import com.deng.tenantapi.domain.Tenant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTenantsQuery {
    private List<Tenant> tenants;
}
