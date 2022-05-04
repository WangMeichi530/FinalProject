package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * Job 信息 数据层
 * 
 * @author ruoyi
 */
public interface SysPostMapper
{
    /**
     * 查询Job 数据集合
     * 
     * @param post Job 信息
     * @return Job 数据集合
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * 查询所有Job 
     * 
     * @return Job 列表
     */
    public List<SysPost> selectPostAll();

    /**
     * 通过Job ID查询Job 信息
     * 
     * @param postId Job ID
     * @return Role对象信息
     */
    public SysPost selectPostById(Long postId);

    /**
     * 根据userID获取Job 选择框列表
     * 
     * @param userId userID
     * @return 选中Job ID列表
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * 查询userAffiliationJob 组
     * 
     * @param userName user名
     * @return 结果
     */
    public List<SysPost> selectPostsByUserName(String userName);

    /**
     * DeleteJob 信息
     * 
     * @param postId Job ID
     * @return 结果
     */
    public int deletePostById(Long postId);

    /**
     * 批量DeleteJob 信息
     * 
     * @param postIds 需要Delete的Job ID
     * @return 结果
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * changeJob 信息
     * 
     * @param post Job 信息
     * @return 结果
     */
    public int updatePost(SysPost post);

    /**
     * AddJob 信息
     * 
     * @param post Job 信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * 校验Job Name
     * 
     * @param postName Job Name
     * @return 结果
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * 校验Job Coding
     * 
     * @param postCode Job Coding
     * @return 结果
     */
    public SysPost checkPostCodeUnique(String postCode);
}
