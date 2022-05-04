package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleMenu;

/**
 * Role与Menu关联表 数据层
 * 
 * @author ruoyi
 */
public interface SysRoleMenuMapper
{
    /**
     * 查询Menu使用数量
     * 
     * @param menuId MenuID
     * @return 结果
     */
    public int checkMenuExistRole(Long menuId);

    /**
     * 通过RoleIDDeleteRole和Menu关联
     * 
     * @param roleId RoleID
     * @return 结果
     */
    public int deleteRoleMenuByRoleId(Long roleId);

    /**
     * 批量DeleteRoleMenu关联信息
     * 
     * @param ids 需要Delete的数据ID
     * @return 结果
     */
    public int deleteRoleMenu(Long[] ids);

    /**
     * 批量AddRoleMenu信息
     * 
     * @param roleMenuList RoleMenu列表
     * @return 结果
     */
    public int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
