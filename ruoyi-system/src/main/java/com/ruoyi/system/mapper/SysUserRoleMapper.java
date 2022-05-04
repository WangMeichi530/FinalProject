package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.SysUserRole;

/**
 * user与Role关联表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserRoleMapper
{
    /**
     * 通过userIDDeleteuser和Role关联
     * 
     * @param userId userID
     * @return 结果
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * 批量Deleteuser和Role关联
     * 
     * @param ids 需要Delete的数据ID
     * @return 结果
     */
    public int deleteUserRole(Long[] ids);

    /**
     * 通过RoleID查询Role使用数量
     * 
     * @param roleId RoleID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 批量AdduserRole信息
     * 
     * @param userRoleList userRole列表
     * @return 结果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
     * Deleteuser和Role关联信息
     * 
     * @param userRole user和Role关联信息
     * @return 结果
     */
    public int deleteUserRoleInfo(SysUserRole userRole);

    /**
     * 批量Cancel授权userRole
     * 
     * @param roleId RoleID
     * @param userIds 需要Delete的user数据ID
     * @return 结果
     */
    public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}
