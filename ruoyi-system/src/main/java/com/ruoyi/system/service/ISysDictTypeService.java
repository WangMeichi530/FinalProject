package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * Dictionary  业务层
 * 
 * @author ruoyi
 */
public interface ISysDictTypeService
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
     * 根据Dictionary type查询Dictionary data
     * 
     * @param dictType Dictionary type
     * @return Dictionary data集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);

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
     * 批量DeleteDictionary 信息
     * 
     * @param dictIds 需要Delete的Dictionary ID
     * @return 结果
     */
    public void deleteDictTypeByIds(Long[] dictIds);

    /**
     * 加载Dictionary 缓存数据
     */
    public void loadingDictCache();

    /**
     * 清空Dictionary 缓存数据
     */
    public void clearDictCache();

    /**
     * ResetDictionary 缓存数据
     */
    public void resetDictCache();

    /**
     * AddKeepDictionary type信息
     * 
     * @param dictType Dictionary type信息
     * @return 结果
     */
    public int insertDictType(SysDictType dictType);

    /**
     * changeKeepDictionary type信息
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
    public String checkDictTypeUnique(SysDictType dictType);
}
