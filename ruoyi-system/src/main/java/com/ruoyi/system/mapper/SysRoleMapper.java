package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysRole;

/**
 * Role表 数据层
 * 
 * @author ruoyi
 */
public interface SysRoleMapper
{
    /**
     * 根据article件分page查询Role数据
     * 
     * @param role Role信息
     * @return Role数据集合信息
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据userID查询Role
     * 
     * @param userId userID
     * @return Role列表
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

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
     * 根据userID查询Role
     * 
     * @param userName user名
     * @return Role列表
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * 校验RoleNameYesNo唯一
     * 
     * @param roleName RoleName
     * @return Role信息
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * 校验Role权限YesNo唯一
     * 
     * @param roleKey Role权限
     * @return Role信息
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * changeRole信息
     * 
     * @param role Role信息
     * @return 结果
     */
    public int updateRole(SysRole role);

    /**
     * AddRole信息
     * 
     * @param role Role信息
     * @return 结果
     */
    public int insertRole(SysRole role);

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
}
