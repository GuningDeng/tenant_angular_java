package com.deng.tenantapi.application.cqrs.tenants;

import java.time.LocalDateTime;

import com.deng.tenantapi.domain.Housing;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTenantCommand {
    private Long id;

    private String idCard;

    private String mobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rentDateTime;

    private Housing housing;
}
