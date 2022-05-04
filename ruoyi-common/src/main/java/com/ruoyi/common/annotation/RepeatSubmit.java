package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotations to prevent duplicate form submissions
 * 
 * @author ruoyi
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit
{
    /**
     * Interval time (ms), less than this time is considered a duplicate submission
     */
    public int interval() default 5000;

    /**
     * Reminder messages
     */
    public String message() default "Repeat submissions are not allowed, please try again later";
}
