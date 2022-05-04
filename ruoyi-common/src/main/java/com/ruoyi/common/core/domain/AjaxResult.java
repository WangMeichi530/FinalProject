package com.ruoyi.common.core.domain;

import java.util.HashMap;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.utils.StringUtils;

/**
 * Operation消息提醒
 * 
 * @author ruoyi
 */
public class AjaxResult extends HashMap<String, Object>
{
    private static final long serialVersionUID = 1L;

    /** Status码 */
    public static final String CODE_TAG = "code";

    /** 返回information */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个New创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }

    /**
     * 初始化一个New创建的 AjaxResult 对象
     * 
     * @param code Status码
     * @param msg 返回information
     */
    public AjaxResult(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个New创建的 AjaxResult 对象
     * 
     * @param code Status码
     * @param msg 返回information
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回Success消息
     * 
     * @return Success消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("OperationSuccess");
    }

    /**
     * 返回Success数据
     * 
     * @return Success消息
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("OperationSuccess", data);
    }

    /**
     * 返回Success消息
     * 
     * @param msg 返回information
     * @return Success消息
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回Success消息
     * 
     * @param msg 返回information
     * @param data 数据对象
     * @return Success消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @return
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("Operation失败");
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回information
     * @return 警告消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 返回information
     * @param data 数据对象
     * @return 警告消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.ERROR, msg, data);
    }

    /**
     * 返回错误消息
     * 
     * @param code Status码
     * @param msg 返回information
     * @return 警告消息
     */
    public static AjaxResult error(int code, String msg)
    {
        return new AjaxResult(code, msg, null);
    }

    /**
     * 方便链式调用
     *
     * @param key 键
     * @param value 值
     * @return 数据对象
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
