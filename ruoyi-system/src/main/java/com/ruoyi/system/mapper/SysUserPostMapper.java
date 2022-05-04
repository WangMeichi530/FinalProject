package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserPost;

/**
 * user与Job 关联表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserPostMapper
{
    /**
     * 通过userIDDeleteuser和Job 关联
     * 
     * @param userId userID
     * @return 结果
     */
    public int deleteUserPostByUserId(Long userId);

    /**
     * 通过Job ID查询Job 使用数量
     * 
     * @param postId Job ID
     * @return 结果
     */
    public int countUserPostById(Long postId);

    /**
     * 批量Deleteuser和Job 关联
     * 
     * @param ids 需要Delete的数据ID
     * @return 结果
     */
    public int deleteUserPost(Long[] ids);

    /**
     * 批量AdduserJob 信息
     * 
     * @param userPostList userRole列表
     * @return 结果
     */
    public int batchUserPost(List<SysUserPost> userPostList);
}
