package com.deng.tenantapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HousingDetailDto {
    private Long Id;
    private String housNumber;
    private String owner;
    private String idCard;
    private Long tenantId;
}
