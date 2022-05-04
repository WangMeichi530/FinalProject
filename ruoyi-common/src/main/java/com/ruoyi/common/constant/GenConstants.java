package com.ruoyi.common.constant;

/**
 * Code generation of generic constants
 * 
 * @author ruoyi
 */
public class GenConstants
{
    /** 单表（增删改查） */
    public static final String TPL_CRUD = "crud";

    /** 树表（增删改查） */
    public static final String TPL_TREE = "tree";

    /** 主子表（增删改查） */
    public static final String TPL_SUB = "sub";

    /** 树Coding字段 */
    public static final String TREE_CODE = "treeCode";

    /** 树父Coding字段 */
    public static final String TREE_PARENT_CODE = "treeParentCode";

    /** 树Name字段 */
    public static final String TREE_NAME = "treeName";

    /** TopMenuID字段 */
    public static final String PARENT_MENU_ID = "parentMenuId";

    /** TopMenuName字段 */
    public static final String PARENT_MENU_NAME = "parentMenuName";

    /** 数据库字符串Type */
    public static final String[] COLUMNTYPE_STR = { "char", "varchar", "nvarchar", "varchar2" };

    /** 数据库TextType */
    public static final String[] COLUMNTYPE_TEXT = { "tinytext", "text", "mediumtext", "longtext" };

    /** 数据库时间Type */
    public static final String[] COLUMNTYPE_TIME = { "datetime", "time", "date", "timestamp" };

    /** 数据库数字Type */
    public static final String[] COLUMNTYPE_NUMBER = { "tinyint", "smallint", "mediumint", "int", "number", "integer",
            "bit", "bigint", "float", "double", "decimal" };

    /** page面不需要编辑字段 */
    public static final String[] COLUMNNAME_NOT_EDIT = { "id", "create_by", "create_time", "del_flag" };

    /** page面不需要show的列表字段 */
    public static final String[] COLUMNNAME_NOT_LIST = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time" };

    /** page面不需要查询字段 */
    public static final String[] COLUMNNAME_NOT_QUERY = { "id", "create_by", "create_time", "del_flag", "update_by",
            "update_time", "remark" };

    /** Entity基类字段 */
    public static final String[] BASE_ENTITY = { "createBy", "createTime", "updateBy", "updateTime", "remark" };

    /** Tree基类字段 */
    public static final String[] TREE_ENTITY = { "parentName", "parentId", "orderNum", "ancestors", "children" };

    /** Text框 */
    public static final String HTML_INPUT = "input";

    /** Text域 */
    public static final String HTML_TEXTAREA = "textarea";

    /** 下拉框 */
    public static final String HTML_SELECT = "select";

    /** 单选框 */
    public static final String HTML_RADIO = "radio";

    /** 复选框 */
    public static final String HTML_CHECKBOX = "checkbox";

    /** 日期控件 */
    public static final String HTML_DATETIME = "datetime";

    /** 图片上传控件 */
    public static final String HTML_IMAGE_UPLOAD = "imageUpload";

    /** 文件上传控件 */
    public static final String HTML_FILE_UPLOAD = "fileUpload";

    /** 富Text控件 */
    public static final String HTML_EDITOR = "editor";

    /** 字符串Type */
    public static final String TYPE_STRING = "String";

    /** 整型 */
    public static final String TYPE_INTEGER = "Integer";

    /** 长整型 */
    public static final String TYPE_LONG = "Long";

    /** 浮点型 */
    public static final String TYPE_DOUBLE = "Double";

    /** 高精度计算Type */
    public static final String TYPE_BIGDECIMAL = "BigDecimal";

    /** 时间Type */
    public static final String TYPE_DATE = "Date";

    /** 模糊查询 */
    public static final String QUERY_LIKE = "LIKE";

    /** 需要 */
    public static final String REQUIRE = "1";
}
