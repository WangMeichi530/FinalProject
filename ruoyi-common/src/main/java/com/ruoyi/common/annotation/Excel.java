package com.ruoyi.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import com.ruoyi.common.utils.poi.ExcelHandlerAdapter;

/**
 * Custom Export Excel Data Annotation
 * 
 * @author ruoyi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Excel
{
    /**
     * Sorting in excel when exporting
     */
    public int sort() default Integer.MAX_VALUE;

    /**
     * Name exported to Excel.
     */
    public String name() default "";

    /**
     * Date format, e.g.: yyyy-MM-dd
     */
    public String dateFormat() default "";

    /**
     * If it is a Dictionary type, set the type value of the Dictionary (e.g.: sys_user_sex)
     */
    public String dictType() default "";

    /**
     * Read content to expression (e.g. 0=male,1=female,2=unknown)
     */
    public String readConverterExp() default "";

    /**
     * Separator, reads the contents of a string group
     */
    public String separator() default ",";

    /**
     * BigDecimal precision default:-1(BigDecimal formatting is not enabled by default)
     */
    public int scale() default -1;

    /**
     * BigDecimal rounding rule default:BigDecimal.ROUND_HALF_EVEN
     */
    public int roundingMode() default BigDecimal.ROUND_HALF_EVEN;

    /**
     * Export type (0 numeric 1 string)
     */
    public ColumnType cellType() default ColumnType.STRING;

    /**
     * Height of each column in excel when exporting in characters
     */
    public double height() default 14;

    /**
     * Width of each column in excel when exporting in characters
     */
    public double width() default 16;

    /**
     * Text suffix, e.g. % 90 becomes 90%
     */
    public String suffix() default "";

    /**
     * Default value of the field when the value is empty
     */
    public String defaultValue() default "";

    /**
     * Tips
     */
    public String prompt() default "";

    /**
     * Set to select only columns that cannot be entered.
     */
    public String[] combo() default {};

    /**
     * Whether or not to export data, in response to demand: sometimes we need to export a template,
     * which is required for the title but the content needs to be filled in manually by USER.
     */
    public boolean isExport() default true;

    /**
     * The name of an attribute in another class, supporting multiple fetching levels, separated by decimal points
     */
    public String targetAttr() default "";

    /**
     * Whether or not to count automatically, adding a row of statistics to the total at the end
     */
    public boolean isStatistics() default false;

    /**
     * Export field alignment (0: default; 1: left of centre; 2: centre; 3: right of centre)
     */
    public Align align() default Align.AUTO;

    /**
     * Customised data processors
     */
    public Class<?> handler() default ExcelHandlerAdapter.class;

    /**
     * Custom data processor parameters
     */
    public String[] args() default {};

    public enum Align
    {
        AUTO(0), LEFT(1), CENTER(2), RIGHT(3);
        private final int value;

        Align(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /**
     * Field type (0: export import; 1: export only; 2: import only)
     */
    Type type() default Type.ALL;

    public enum Type
    {
        ALL(0), EXPORT(1), IMPORT(2);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    public enum ColumnType
    {
        NUMERIC(0), STRING(1), IMAGE(2);
        private final int value;

        ColumnType(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }
}