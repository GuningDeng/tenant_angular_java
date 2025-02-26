package com.deng.tenantapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AutoLogEnum {
    /**
     * Operation log
     */
    LOG_TYPE_1(1, "Operation log"),
    /**
     * Access log
     */
    LOG_TYPE_2(2, "Access log"),
    /**
     * Exception log
     */
    LOG_TYPE_3(3, "Exception log");
    
    final Integer value;
    final String type;
}
