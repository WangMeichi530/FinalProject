package com.ruoyi.common.constant;

/**
 * user常量信息
 * 
 * @author ruoyi
 */
public class UserConstants
{
    /**
     * 平台内系统user的唯一标志
     */
    public static final String SYS_USER = "SYS_USER";

    /** 正常Status */
    public static final String NORMAL = "0";

    /** 异常Status */
    public static final String EXCEPTION = "1";

    /** user封禁Status */
    public static final String USER_DISABLE = "1";

    /** Role封禁Status */
    public static final String ROLE_DISABLE = "1";

    /** 部门正常Status */
    public static final String DEPT_NORMAL = "0";

    /** 部门停用Status */
    public static final String DEPT_DISABLE = "1";

    /** Dictionary 正常Status */
    public static final String DICT_NORMAL = "0";

    /** YesNois系统默认（Yes） */
    public static final String YES = "Y";

    /** YesNoMenu外链（Yes） */
    public static final String YES_FRAME = "0";

    /** YesNoMenu外链（No） */
    public static final String NO_FRAME = "1";

    /** MenuType（Directory） */
    public static final String TYPE_DIR = "M";

    /** MenuType（Menu） */
    public static final String TYPE_MENU = "C";

    /** MenuType（button） */
    public static final String TYPE_BUTTON = "F";

    /** Layout组件标识 */
    public final static String LAYOUT = "Layout";
    
    /** ParentView组件标识 */
    public final static String PARENT_VIEW = "ParentView";

    /** InnerLink组件标识 */
    public final static String INNER_LINK = "InnerLink";

    /** 校验返回结果码 */
    public final static String UNIQUE = "0";
    public final static String NOT_UNIQUE = "1";

    /**
     * user名长度限制
     */
    public static final int USERNAME_MIN_LENGTH = 2;
    public static final int USERNAME_MAX_LENGTH = 20;

    /**
     * password长度限制
     */
    public static final int PASSWORD_MIN_LENGTH = 5;
    public static final int PASSWORD_MAX_LENGTH = 20;
}
