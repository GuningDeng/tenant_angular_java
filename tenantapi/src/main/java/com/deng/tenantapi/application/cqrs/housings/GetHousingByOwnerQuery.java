package com.deng.tenantapi.application.cqrs.housings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetHousingByOwnerQuery {
    private String owner;
}
