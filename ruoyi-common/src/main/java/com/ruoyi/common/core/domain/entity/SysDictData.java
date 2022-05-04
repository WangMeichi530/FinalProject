package com.ruoyi.common.core.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Dictionary data表 sys_dict_data
 * 
 * @author ruoyi
 */
public class SysDictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Dictionary Coding */
    @Excel(name = "Dictionary Coding", cellType = ColumnType.NUMERIC)
    private Long dictCode;

    /** Dictionary sort */
    @Excel(name = "Dictionary sort", cellType = ColumnType.NUMERIC)
    private Long dictSort;

    /** Dictionary 标签 */
    @Excel(name = "Dictionary 标签")
    private String dictLabel;

    /** Dictionary 键值 */
    @Excel(name = "Dictionary 键值")
    private String dictValue;

    /** Dictionary type */
    @Excel(name = "Dictionary type")
    private String dictType;

    /** 样式属性（其他样式扩展） */
    private String cssClass;

    /** 表格Dictionary 样式 */
    private String listClass;

    /** YesNo默认（YYes NNo） */
    @Excel(name = "YesNo默认", readConverterExp = "Y=Yes,N=No")
    private String isDefault;

    /** Status（0正常 1停用） */
    @Excel(name = "Status", readConverterExp = "0=正常,1=停用")
    private String status;

    public Long getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(Long dictCode)
    {
        this.dictCode = dictCode;
    }

    public Long getDictSort()
    {
        return dictSort;
    }

    public void setDictSort(Long dictSort)
    {
        this.dictSort = dictSort;
    }

    @NotBlank(message = "Dictionary 标签cannot be empty")
    @Size(min = 0, max = 100, message = "Dictionary 标签length cannot exceed 100 characters")
    public String getDictLabel()
    {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel)
    {
        this.dictLabel = dictLabel;
    }

    @NotBlank(message = "Dictionary 键值cannot be empty")
    @Size(min = 0, max = 100, message = "Dictionary 键值length cannot exceed 100 characters")
    public String getDictValue()
    {
        return dictValue;
    }

    public void setDictValue(String dictValue)
    {
        this.dictValue = dictValue;
    }

    @NotBlank(message = "Dictionary typecannot be empty")
    @Size(min = 0, max = 100, message = "Dictionary typelength cannot exceed 100 characters")
    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    @Size(min = 0, max = 100, message = "样式属性length cannot exceed 100 characters")
    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getListClass()
    {
        return listClass;
    }

    public void setListClass(String listClass)
    {
        this.listClass = listClass;
    }

    public boolean getDefault()
    {
        return UserConstants.YES.equals(this.isDefault) ? true : false;
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dictCode", getDictCode())
            .append("dictSort", getDictSort())
            .append("dictLabel", getDictLabel())
            .append("dictValue", getDictValue())
            .append("dictType", getDictType())
            .append("cssClass", getCssClass())
            .append("listClass", getListClass())
            .append("isDefault", getIsDefault())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
