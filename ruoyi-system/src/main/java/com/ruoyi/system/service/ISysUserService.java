package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * user 业务层
 * 
 * @author ruoyi
 */
public interface ISysUserService
{
    /**
     * 根据article件分page查询user列表
     * 
     * @param user user信息
     * @return user信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 根据article件分page查询已AllocationuserRole列表
     * 
     * @param user user信息
     * @return user信息集合信息
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根据article件分page查询未AllocationuserRole列表
     * 
     * @param user user信息
     * @return user信息集合信息
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过user名查询user
     * 
     * @param userName user名
     * @return user对象信息
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * 通过userID查询user
     * 
     * @param userId userID
     * @return user对象信息
     */
    public SysUser selectUserById(Long userId);

    /**
     * 根据userID查询userAffiliationRole组
     * 
     * @param userName user名
     * @return 结果
     */
    public String selectUserRoleGroup(String userName);

    /**
     * 根据userID查询userAffiliationJob 组
     * 
     * @param userName user名
     * @return 结果
     */
    public String selectUserPostGroup(String userName);

    /**
     * 校验userNameYesNo唯一
     * 
     * @param userName userName
     * @return 结果
     */
    public String checkUserNameUnique(String userName);

    /**
     * 校验Phone NumberYesNo唯一
     *
     * @param user user信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验emailYesNo唯一
     *
     * @param user user信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);

    /**
     * 校验userYesNo允许Operation
     * 
     * @param user user信息
     */
    public void checkUserAllowed(SysUser user);

    /**
     * 校验userYesNo有Data permissions
     * 
     * @param userId userid
     */
    public void checkUserDataScope(Long userId);

    /**
     * Adduser信息
     * 
     * @param user user信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * registeruser信息
     * 
     * @param user user信息
     * @return 结果
     */
    public boolean registerUser(SysUser user);

    /**
     * changeuser信息
     * 
     * @param user user信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * user授权Role
     * 
     * @param userId userID
     * @param roleIds Role组
     */
    public void insertUserAuth(Long userId, Long[] roleIds);

    /**
     * changeuserStatus
     * 
     * @param user user信息
     * @return 结果
     */
    public int updateUserStatus(SysUser user);

    /**
     * changeuser基本信息
     * 
     * @param user user信息
     * @return 结果
     */
    public int updateUserProfile(SysUser user);

    /**
     * changeuseravatar
     * 
     * @param userName user名
     * @param avatar avatarAddress
     * @return 结果
     */
    public boolean updateUserAvatar(String userName, String avatar);

    /**
     * Resetuserpassword
     * 
     * @param user user信息
     * @return 结果
     */
    public int resetPwd(SysUser user);

    /**
     * Resetuserpassword
     * 
     * @param userName user名
     * @param password password
     * @return 结果
     */
    public int resetUserPwd(String userName, String password);

    /**
     * 通过userIDDeleteuser
     * 
     * @param userId userID
     * @return 结果
     */
    public int deleteUserById(Long userId);

    /**
     * 批量Deleteuser信息
     * 
     * @param userIds 需要Delete的userID
     * @return 结果
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * Importuser数据
     * 
     * @param userList user数据列表
     * @param isUpdateSupport YesNo更New支持，like果已存在，则进行更New数据
     * @param operName Operationuser
     * @return 结果
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);
}
