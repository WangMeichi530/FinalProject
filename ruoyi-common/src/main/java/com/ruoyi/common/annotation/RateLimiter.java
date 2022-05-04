package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.enums.LimitType;

/**
 * Flow Restriction Notes
 * 
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter
{
    /**
     * Current limiting key
     */
    public String key() default Constants.RATE_LIMIT_KEY;

    /**
     * Flow limitation time in seconds
     */
    public int time() default 60;

    /**
     * Number of flow limits
     */
    public int count() default 100;

    /**
     * Type of flow limitation
     */
    public LimitType limitType() default LimitType.DEFAULT;
}
