package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysUserRole;

/**
 * Role业务层
 * 
 * @author ruoyi
 */
public interface ISysRoleService
{
    /**
     * 根据article件分page查询Role数据
     * 
     * @param role Role信息
     * @return Role数据集合信息
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据userID查询Role列表
     * 
     * @param userId userID
     * @return Role列表
     */
    public List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据userID查询Role权限
     * 
     * @param userId userID
     * @return 权限列表
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * 查询所有Role
     * 
     * @return Role列表
     */
    public List<SysRole> selectRoleAll();

    /**
     * 根据userID获取Role选择框列表
     * 
     * @param userId userID
     * @return 选中RoleID列表
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * 通过RoleID查询Role
     * 
     * @param roleId RoleID
     * @return Role对象信息
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * 校验RoleNameYesNo唯一
     * 
     * @param role Role信息
     * @return 结果
     */
    public String checkRoleNameUnique(SysRole role);

    /**
     * 校验Role权限YesNo唯一
     * 
     * @param role Role信息
     * @return 结果
     */
    public String checkRoleKeyUnique(SysRole role);

    /**
     * 校验RoleYesNo允许Operation
     * 
     * @param role Role信息
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * 校验RoleYesNo有Data permissions
     * 
     * @param roleId Roleid
     */
    public void checkRoleDataScope(Long roleId);

    /**
     * 通过RoleID查询Role使用数量
     * 
     * @param roleId RoleID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * AddKeepRole信息
     * 
     * @param role Role信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    /**
     * changeKeepRole信息
     * 
     * @param role Role信息
     * @return 结果
     */
    public int updateRole(SysRole role);

    /**
     * changeRoleStatus
     * 
     * @param role Role信息
     * @return 结果
     */
    public int updateRoleStatus(SysRole role);

    /**
     * changeData permissions信息
     * 
     * @param role Role信息
     * @return 结果
     */
    public int authDataScope(SysRole role);

    /**
     * 通过RoleIDDeleteRole
     * 
     * @param roleId RoleID
     * @return 结果
     */
    public int deleteRoleById(Long roleId);

    /**
     * 批量DeleteRole信息
     * 
     * @param roleIds 需要Delete的RoleID
     * @return 结果
     */
    public int deleteRoleByIds(Long[] roleIds);

    /**
     * Cancel授权userRole
     * 
     * @param userRole user和Role关联信息
     * @return 结果
     */
    public int deleteAuthUser(SysUserRole userRole);

    /**
     * 批量Cancel授权userRole
     * 
     * @param roleId RoleID
     * @param userIds 需要Cancel授权的user数据ID
     * @return 结果
     */
    public int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * 批量选择授权userRole
     * 
     * @param roleId RoleID
     * @param userIds 需要Delete的user数据ID
     * @return 结果
     */
    public int insertAuthUsers(Long roleId, Long[] userIds);
}
