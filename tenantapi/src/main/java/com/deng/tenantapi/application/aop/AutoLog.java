package com.deng.tenantapi.application.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.deng.tenantapi.domain.enums.AutoLogEnum;
import com.deng.tenantapi.domain.enums.AutoLogOperateEnum;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLog {
    /**
     * log content
     * @return log content
     */
    String value() default "";

    /**
     * log type
     * 
     * @return 1,access log. 2,operate log. 3,exepction log.
     */
    AutoLogEnum logType() default AutoLogEnum.LOG_TYPE_1;

    /**
     * operation type
     * 
     * @return 1,read. 2,create. 3,update. 4,delete
     */
    AutoLogOperateEnum operateType() default AutoLogOperateEnum.OPERATE_TYPE_1;
    
}
