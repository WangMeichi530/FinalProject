package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.SysUserOnline;

/**
 * 在线user 服务层
 * 
 * @author ruoyi
 */
public interface ISysUserOnlineService
{
    /**
     * 通过logAddress查询信息
     * 
     * @param ipaddr logAddress
     * @param user user信息
     * @return 在线user信息
     */
    public SysUserOnline selectOnlineByIpaddr(String ipaddr, LoginUser user);

    /**
     * 通过userName查询信息
     * 
     * @param userName userName
     * @param user user信息
     * @return 在线user信息
     */
    public SysUserOnline selectOnlineByUserName(String userName, LoginUser user);

    /**
     * 通过logAddress/userName查询信息
     * 
     * @param ipaddr logAddress
     * @param userName userName
     * @param user user信息
     * @return 在线user信息
     */
    public SysUserOnline selectOnlineByInfo(String ipaddr, String userName, LoginUser user);

    /**
     * Set在线user信息
     * 
     * @param user user信息
     * @return 在线user
     */
    public SysUserOnline loginUserToUserOnline(LoginUser user);
}
