package com.deng.tenantapi.application.cqrs.housings;

import com.deng.tenantapi.application.dto.HousingDetailDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHousingCommand {
    private Long id;
    private HousingDetailDto housingDetailDto;
}
