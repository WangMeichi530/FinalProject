package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.domain.vo.RouterVo;

/**
 * Menu 业务层
 * 
 * @author ruoyi
 */
public interface ISysMenuService
{
    /**
     * 根据user查询系统Menu列表
     * 
     * @param userId userID
     * @return Menu列表
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * 根据user查询系统Menu列表
     * 
     * @param menu Menu信息
     * @param userId userID
     * @return Menu列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * 根据userID查询权限
     * 
     * @param userId userID
     * @return 权限列表
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据userID查询Menu树信息
     * 
     * @param userId userID
     * @return Menu列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根据RoleID查询Menu树信息
     * 
     * @param roleId RoleID
     * @return 选中Menu列表
     */
    public List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * 构建前端Routing所需要的Menu
     * 
     * @param menus Menu列表
     * @return Routing列表
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * 构建前端所需要树结构
     * 
     * @param menus Menu列表
     * @return 树结构列表
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param menus Menu列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * 根据MenuID查询信息
     * 
     * @param menuId MenuID
     * @return Menu信息
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * YesNo存在Menu子节点
     * 
     * @param menuId MenuID
     * @return 结果 true 存在 false 不存在
     */
    public boolean hasChildByMenuId(Long menuId);

    /**
     * 查询MenuYesNo存在Role
     * 
     * @param menuId MenuID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkMenuExistRole(Long menuId);

    /**
     * AddKeepMenu信息
     * 
     * @param menu Menu信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu);

    /**
     * changeKeepMenu信息
     * 
     * @param menu Menu信息
     * @return 结果
     */
    public int updateMenu(SysMenu menu);

    /**
     * DeleteMenu management信息
     * 
     * @param menuId MenuID
     * @return 结果
     */
    public int deleteMenuById(Long menuId);

    /**
     * 校验MenuNameYesNo唯一
     * 
     * @param menu Menu信息
     * @return 结果
     */
    public String checkMenuNameUnique(SysMenu menu);
}
