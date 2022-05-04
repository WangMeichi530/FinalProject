package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleDept;

/**
 * Role与部门关联表 数据层
 * 
 * @author ruoyi
 */
public interface SysRoleDeptMapper
{
    /**
     * 通过RoleIDDeleteRole和部门关联
     * 
     * @param roleId RoleID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * 批量DeleteRole部门关联信息
     * 
     * @param ids 需要Delete的数据ID
     * @return 结果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * 查询部门使用数量
     * 
     * @param deptId 部门ID
     * @return 结果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * 批量AddRole部门信息
     * 
     * @param roleDeptList Role部门列表
     * @return 结果
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}
