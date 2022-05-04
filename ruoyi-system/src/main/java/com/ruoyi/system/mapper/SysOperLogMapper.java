package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysOperLog;

/**
 * Operation log 数据层
 * 
 * @author ruoyi
 */
public interface SysOperLogMapper
{
    /**
     * AddOperation log
     * 
     * @param operLog Operation log对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统Operation log集合
     * 
     * @param operLog Operation log对象
     * @return Operation log集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 批量Delete系统Operation log
     * 
     * @param operIds 需要Delete的Operation logID
     * @return 结果
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * 查询Operation log详细
     * 
     * @param operId OperationID
     * @return Operation log对象
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * 清空Operation log
     */
    public void cleanOperLog();
}
