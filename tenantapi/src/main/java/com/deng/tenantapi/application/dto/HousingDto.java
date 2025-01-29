package com.deng.tenantapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HousingDto {
    private String housNumber;
    private String owner;
    public HousingDto() {
    }
     
}
