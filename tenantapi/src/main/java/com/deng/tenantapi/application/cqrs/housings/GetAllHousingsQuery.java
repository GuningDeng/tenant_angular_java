package com.deng.tenantapi.application.cqrs.housings;

import java.util.List;

import com.deng.tenantapi.application.dto.HousingDetailDto;
import com.deng.tenantapi.domain.Housing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllHousingsQuery {
    private List<HousingDetailDto> housings;
}
