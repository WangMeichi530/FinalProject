package com.ruoyi.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 *  sys_config
 * 
 * @author ruoyi
 */
public class SysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Parameter primary key */
    @Excel(name = "Parameter primary key", cellType = ColumnType.NUMERIC)
    private Long configId;

    /** Parameter name */
    @Excel(name = "Parameter name")
    private String configName;

    /** Parameter Key Name */
    @Excel(name = "Parameter Key Name")
    private String configKey;

    /** Parameter Key Value */
    @Excel(name = "Parameter Key Value")
    private String configValue;

    /** System built-in (Y yes N no) */
    @Excel(name = "System built-in", readConverterExp = "Y=yes,N=no")
    private String configType;

    public Long getConfigId()
    {
        return configId;
    }

    public void setConfigId(Long configId)
    {
        this.configId = configId;
    }

    @NotBlank(message = "Parameter namecannot be empty")
    @Size(min = 0, max = 100, message = "Parameter name cannot exceed 100 characters")
    public String getConfigName()
    {
        return configName;
    }

    public void setConfigName(String configName)
    {
        this.configName = configName;
    }

    @NotBlank(message = "Parameter Key Name length cannot be empty")
    @Size(min = 0, max = 100, message = "Parameter Key Name length cannot exceed 100 characters")
    public String getConfigKey()
    {
        return configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    @NotBlank(message = "Parameter Key Valuecannot be empty")
    @Size(min = 0, max = 500, message = "Parameter Key Value length cannot exceed 500 characters")
    public String getConfigValue()
    {
        return configValue;
    }

    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    public String getConfigType()
    {
        return configType;
    }

    public void setConfigType(String configType)
    {
        this.configType = configType;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("configId", getConfigId())
            .append("configName", getConfigName())
            .append("configKey", getConfigKey())
            .append("configValue", getConfigValue())
            .append("configType", getConfigType())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
