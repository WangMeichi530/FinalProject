package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;

/**
 * Home
 *
 * @author ruoyi
 */
@RestController
public class SysIndexController
{
    /** System base configuration */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /**
     * Visit Home, Prompt
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("Welcome to the {} backend administration framework, current version: v{}, please access via the front end address.", ruoyiConfig.getName(), ruoyiConfig.getVersion());
    }
}
