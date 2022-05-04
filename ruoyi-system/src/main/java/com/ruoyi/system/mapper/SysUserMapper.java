package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * user表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserMapper
{
    /**
     * 根据article件分page查询user列表
     * 
     * @param sysUser user信息
     * @return user信息集合信息
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 根据article件分page查询未已配userRole列表
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
     * Adduser信息
     * 
     * @param user user信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * changeuser信息
     * 
     * @param user user信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * changeuseravatar
     * 
     * @param userName user名
     * @param avatar avatarAddress
     * @return 结果
     */
    public int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * Resetuserpassword
     * 
     * @param userName user名
     * @param password password
     * @return 结果
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

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
     * 校验userNameYesNo唯一
     * 
     * @param userName userName
     * @return 结果
     */
    public int checkUserNameUnique(String userName);

    /**
     * 校验Phone NumberYesNo唯一
     *
     * @param phonenumber Phone Number
     * @return 结果
     */
    public SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校验emailYesNo唯一
     *
     * @param email userE-mail
     * @return 结果
     */
    public SysUser checkEmailUnique(String email);
}
