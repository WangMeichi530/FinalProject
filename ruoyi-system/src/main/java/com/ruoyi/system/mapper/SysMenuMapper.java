package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysMenu;

/**
 * Menu表 数据层
 *
 * @author ruoyi
 */
public interface SysMenuMapper
{
    /**
     * 查询系统Menu列表
     *
     * @param menu Menu信息
     * @return Menu列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * 根据user所有权限
     *
     * @return 权限列表
     */
    public List<String> selectMenuPerms();

    /**
     * 根据user查询系统Menu列表
     *
     * @param menu Menu信息
     * @return Menu列表
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * 根据userID查询权限
     *
     * @param userId userID
     * @return 权限列表
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * 根据userID查询Menu
     *
     * @return Menu列表
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * 根据userID查询Menu
     *
     * @param userId userID
     * @return Menu列表
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * 根据RoleID查询Menu树信息
     * 
     * @param roleId RoleID
     * @param menuCheckStrictly Menu树选择项YesNo关联show
     * @return 选中Menu列表
     */
    public List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

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
     * @return 结果
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * AddMenu信息
     *
     * @param menu Menu信息
     * @return 结果
     */
    public int insertMenu(SysMenu menu);

    /**
     * changeMenu信息
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
     * @param menuName MenuName
     * @param parentId 父MenuID
     * @return 结果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}
