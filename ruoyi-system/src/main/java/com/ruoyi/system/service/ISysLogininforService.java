package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;

/**
 * 系统访问日志情况信息 服务层
 * 
 * @author ruoyi
 */
public interface ISysLogininforService
{
    /**
     * Add系统log日志
     * 
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询系统log日志集合
     * 
     * @param logininfor 访问日志对象
     * @return log记录集合
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 批量Delete系统log日志
     * 
     * @param infoIds 需要Delete的log日志ID
     * @return
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空系统log日志
     */
    public void cleanLogininfor();
}
