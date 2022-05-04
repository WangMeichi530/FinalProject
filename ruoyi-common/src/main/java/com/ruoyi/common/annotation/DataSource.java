package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.enums.DataSourceType;

/**
 * Custom multi-data source switching annotations
 *
 * Priority: method first, then class, if the method overrides the data source type on the class, the method's prevails, otherwise the class's prevails
 *
 * @author ruoyi
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    /**
     * Switching data source names
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
