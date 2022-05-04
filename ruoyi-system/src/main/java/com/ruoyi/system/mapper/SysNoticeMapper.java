package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

/**
 * 通知Product表 数据层
 * 
 * @author ruoyi
 */
public interface SysNoticeMapper
{
    /**
     * 查询Product信息
     * 
     * @param noticeId ProductID
     * @return Product信息
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * 查询Product列表
     * 
     * @param notice Product信息
     * @return Product集合
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * 查询Product列表
     *
     * @param notice Product信息
     * @return Product集合
     */
    public List<SysNotice> selectNoticeListById(SysNotice notice);

    /**
     * AddProduct
     * 
     * @param notice Product信息
     * @return 结果
     */
    public int insertNotice(SysNotice notice);

    /**
     * changeProduct
     * 
     * @param notice Product信息
     * @return 结果
     */
    public int updateNotice(SysNotice notice);

    /**
     * 批量DeleteProduct
     * 
     * @param noticeId ProductID
     * @return 结果
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * 批量DeleteProduct信息
     * 
     * @param noticeIds 需要Delete的ProductID
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}
