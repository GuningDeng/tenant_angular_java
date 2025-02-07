package com.deng.tenantapi.application.dto;

import java.time.LocalDateTime;

import com.deng.tenantapi.domain.Housing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenantDetailDto {
    private Long id;
    private String idCard;
    private String mobile;
    private LocalDateTime rentDateTime;
    private Housing housing;
}
