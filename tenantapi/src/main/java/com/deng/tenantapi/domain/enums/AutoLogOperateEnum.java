package com.deng.tenantapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AutoLogOperateEnum {
    /**
     * Read
     */
    OPERATE_TYPE_1(1, "Read"),
    /**
     * Create
     */
    OPERATE_TYPE_2(2, "Create"),
    /**
     * Update
     */
    OPERATE_TYPE_3(3, "Update"),
    /**
     * Delete
     */
    OPERATE_TYPE_4(4, "Delete");

    final Integer value;
    final String type;

}
