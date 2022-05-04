package com.ruoyi.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Role表 sys_role
 * 
 * @author ruoyi
 */
public class SysRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** RoleID */
    @Excel(name = "RoleSerial number", cellType = ColumnType.NUMERIC)
    private Long roleId;

    /** RoleName */
    @Excel(name = "RoleName")
    private String roleName;

    /** Role权限 */
    @Excel(name = "Role权限")
    private String roleKey;

    /** Rolesort */
    @Excel(name = "Rolesort")
    private String roleSort;

    /** 数据范围（1：所有Data permissions；2：自定义Data permissions；3：本部门Data permissions；4：本部门及以下Data permissions；5：仅本人Data permissions） */
    @Excel(name = "数据范围", readConverterExp = "1=所有Data permissions,2=自定义Data permissions,3=本部门Data permissions,4=本部门及以下Data permissions,5=仅本人Data permissions")
    private String dataScope;

    /** Menu树选择项YesNo关联show（ 0：父子不互相关联show 1：父子互相关联show） */
    private boolean menuCheckStrictly;

    /** 部门树选择项YesNo关联show（0：父子不互相关联show 1：父子互相关联show ） */
    private boolean deptCheckStrictly;

    /** RoleStatus（0正常 1停用） */
    @Excel(name = "RoleStatus", readConverterExp = "0=正常,1=停用")
    private String status;

    /** Delete标志（0代表存在 2代表Delete） */
    private String delFlag;

    /** userYesNo存在此Role标识 默认不存在 */
    private boolean flag = false;

    /** Menu组 */
    private Long[] menuIds;

    /** 部门组（Data permissions） */
    private Long[] deptIds;

    public SysRole()
    {

    }

    public SysRole(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public boolean isAdmin()
    {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId)
    {
        return roleId != null && 1L == roleId;
    }

    @NotBlank(message = "RoleNamecannot be empty")
    @Size(min = 0, max = 30, message = "RoleName长度不能超过30个字符")
    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    @NotBlank(message = "Permission characterscannot be empty")
    @Size(min = 0, max = 100, message = "Permission characterslength cannot exceed 100 characters")
    public String getRoleKey()
    {
        return roleKey;
    }

    public void setRoleKey(String roleKey)
    {
        this.roleKey = roleKey;
    }

    @NotBlank(message = "Display ordercannot be empty")
    public String getRoleSort()
    {
        return roleSort;
    }

    public void setRoleSort(String roleSort)
    {
        this.roleSort = roleSort;
    }

    public String getDataScope()
    {
        return dataScope;
    }

    public void setDataScope(String dataScope)
    {
        this.dataScope = dataScope;
    }

    public boolean isMenuCheckStrictly()
    {
        return menuCheckStrictly;
    }

    public void setMenuCheckStrictly(boolean menuCheckStrictly)
    {
        this.menuCheckStrictly = menuCheckStrictly;
    }

    public boolean isDeptCheckStrictly()
    {
        return deptCheckStrictly;
    }

    public void setDeptCheckStrictly(boolean deptCheckStrictly)
    {
        this.deptCheckStrictly = deptCheckStrictly;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public Long[] getMenuIds()
    {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds)
    {
        this.menuIds = menuIds;
    }

    public Long[] getDeptIds()
    {
        return deptIds;
    }

    public void setDeptIds(Long[] deptIds)
    {
        this.deptIds = deptIds;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("roleKey", getRoleKey())
            .append("roleSort", getRoleSort())
            .append("dataScope", getDataScope())
            .append("menuCheckStrictly", isMenuCheckStrictly())
            .append("deptCheckStrictly", isDeptCheckStrictly())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
