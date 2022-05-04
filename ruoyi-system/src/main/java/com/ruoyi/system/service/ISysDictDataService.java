package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * Dictionary  业务层
 * 
 * @author ruoyi
 */
public interface ISysDictDataService
{
    /**
     * 根据article件分page查询Dictionary data
     * 
     * @param dictData Dictionary data信息
     * @return Dictionary data集合信息
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据Dictionary type和Dictionary 键值查询Dictionary data信息
     * 
     * @param dictType Dictionary type
     * @param dictValue Dictionary 键值
     * @return Dictionary 标签
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据Dictionary dataID查询信息
     * 
     * @param dictCode Dictionary dataID
     * @return Dictionary data
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * 批量DeleteDictionary data信息
     * 
     * @param dictCodes 需要Delete的Dictionary dataID
     * @return 结果
     */
    public void deleteDictDataByIds(Long[] dictCodes);

    /**
     * AddKeepDictionary data信息
     * 
     * @param dictData Dictionary data信息
     * @return 结果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * changeKeepDictionary data信息
     * 
     * @param dictData Dictionary data信息
     * @return 结果
     */
    public int updateDictData(SysDictData dictData);
}
