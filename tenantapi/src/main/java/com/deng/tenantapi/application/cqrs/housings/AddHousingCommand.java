package com.deng.tenantapi.application.cqrs.housings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHousingCommand {
    private Long id;

    private String housNumber;
    private String owner;
    private String idCard;
}
