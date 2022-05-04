package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * Job 信息 服务层
 * 
 * @author ruoyi
 */
public interface ISysPostService
{
    /**
     * 查询Job 信息集合
     * 
     * @param post Job 信息
     * @return Job 列表
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
     * 校验Job Name
     * 
     * @param post Job 信息
     * @return 结果
     */
    public String checkPostNameUnique(SysPost post);

    /**
     * 校验Job Coding
     * 
     * @param post Job 信息
     * @return 结果
     */
    public String checkPostCodeUnique(SysPost post);

    /**
     * 通过Job ID查询Job 使用数量
     * 
     * @param postId Job ID
     * @return 结果
     */
    public int countUserPostById(Long postId);

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
     * @throws Exception 异常
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * AddKeepJob 信息
     * 
     * @param post Job 信息
     * @return 结果
     */
    public int insertPost(SysPost post);

    /**
     * changeKeepJob 信息
     * 
     * @param post Job 信息
     * @return 结果
     */
    public int updatePost(SysPost post);
}
