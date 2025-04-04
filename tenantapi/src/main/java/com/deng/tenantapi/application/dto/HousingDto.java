package com.deng.tenantapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @Builder
@NoArgsConstructor
@AllArgsConstructor
public class HousingDto {
    private Long id;
    private String housNumber;
    private String owner;
    // public HousingDto() {
    // }
     
}
