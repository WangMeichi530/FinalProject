package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * Dictionary 表 数据层
 * 
 * @author ruoyi
 */
@Mapper
public interface SysDictTypeMapper
{
    /**
     * 根据article件分page查询Dictionary type
     * 
     * @param dictType Dictionary type信息
     * @return Dictionary type集合信息
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 根据所有Dictionary type
     * 
     * @return Dictionary type集合信息
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * 根据Dictionary typeID查询信息
     * 
     * @param dictId Dictionary typeID
     * @return Dictionary type
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * 根据Dictionary type查询信息
     * 
     * @param dictType Dictionary type
     * @return Dictionary type
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * 通过Dictionary IDDeleteDictionary 信息
     * 
     * @param dictId Dictionary ID
     * @return 结果
     */
    public int deleteDictTypeById(Long dictId);

    /**
     * 批量DeleteDictionary type信息
     * 
     * @param dictIds 需要Delete的Dictionary ID
     * @return 结果
     */
    public int deleteDictTypeByIds(Long[] dictIds);

    /**
     * AddDictionary type信息
     * 
     * @param dictType Dictionary type信息
     * @return 结果
     */
    public int insertDictType(SysDictType dictType);

    /**
     * changeDictionary type信息
     * 
     * @param dictType Dictionary type信息
     * @return 结果
     */
    public int updateDictType(SysDictType dictType);

    /**
     * 校验Dictionary type称YesNo唯一
     * 
     * @param dictType Dictionary type
     * @return 结果
     */
    public SysDictType checkDictTypeUnique(String dictType);
}
