package com.deng.tenantapi.application.cqrs.tenants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteTenantCommand {
    private Long Id;
}
