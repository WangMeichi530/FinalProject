package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * Dictionary 表 数据层
 * 
 * @author ruoyi
 */
public interface SysDictDataMapper
{
    /**
     * 根据article件分page查询Dictionary data
     * 
     * @param dictData Dictionary data信息
     * @return Dictionary data集合信息
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据Dictionary type查询Dictionary data
     * 
     * @param dictType Dictionary type
     * @return Dictionary data集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据Dictionary type和Dictionary 键值查询Dictionary data信息
     * 
     * @param dictType Dictionary type
     * @param dictValue Dictionary 键值
     * @return Dictionary 标签
     */
    public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * 根据Dictionary dataID查询信息
     * 
     * @param dictCode Dictionary dataID
     * @return Dictionary data
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * 查询Dictionary data
     * 
     * @param dictType Dictionary type
     * @return Dictionary data
     */
    public int countDictDataByType(String dictType);

    /**
     * 通过Dictionary IDDeleteDictionary data信息
     * 
     * @param dictCode Dictionary dataID
     * @return 结果
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * 批量DeleteDictionary data信息
     * 
     * @param dictCodes 需要Delete的Dictionary dataID
     * @return 结果
     */
    public int deleteDictDataByIds(Long[] dictCodes);

    /**
     * AddDictionary data信息
     * 
     * @param dictData Dictionary data信息
     * @return 结果
     */
    public int insertDictData(SysDictData dictData);

    /**
     * changeDictionary data信息
     * 
     * @param dictData Dictionary data信息
     * @return 结果
     */
    public int updateDictData(SysDictData dictData);

    /**
     * 同步changeDictionary type
     * 
     * @param oldDictType oldDictionary type
     * @param newDictType NewoldDictionary type
     * @return 结果
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}
