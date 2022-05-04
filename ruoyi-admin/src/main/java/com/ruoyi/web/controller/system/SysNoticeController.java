package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysNoticeService;

/**
 * Announcements Information handling
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/system/notice")
public class SysNoticeController extends BaseController
{
    @Autowired
    private ISysNoticeService noticeService;

    /**
     * Get a list of announcements
     */
    @PreAuthorize("@ss.hasPermi('system:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysNotice notice)
    {

        List<SysNotice> list = null;
        Map<String, Object> params = notice.getParams();
        String menuId = params.get("menuId")+"";
        if ("107".equals(menuId)){
            startPage();
            list = noticeService.selectNoticeList(notice);
        }else if ("2000".equals(menuId)){

            Long userId = SecurityUtils.getUserId();
            String username = SecurityUtils.getUsername();
            notice.setCreateBy(username);
            startPage();
            list = noticeService.selectNoticeList(notice);
        }else if ("2001".equals(menuId)){
            startPage();
            list = noticeService.selectNoticeListById(notice);
        }




        return getDataTable(list);
    }

    /**
     * Get details by notice number
     */
    @PreAuthorize("@ss.hasPermi('system:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable Long noticeId)
    {
        return AjaxResult.success(noticeService.selectNoticeById(noticeId));
    }

    /**
     * Add Notice Notice
     */
    @PreAuthorize("@ss.hasPermi('system:notice:add')")
    @Log(title = "Notice", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysNotice notice)
    {
        notice.setCreateBy(getUsername());
        return toAjax(noticeService.insertNotice(notice));
    }

    /**
     * change notice announcement
     */
    @PreAuthorize("@ss.hasPermi('system:notice:edit')")
    @Log(title = "Notice", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysNotice notice)
    {
        notice.setUpdateBy(getUsername());
        String noticeId = notice.getNoticeId()+"";
        String remark = notice.getRemark() + "";
        notice.setRemark(null);
        int i = noticeService.updateNotice(notice);

        notice.setCreateBy(getUsername());
        notice.setNoticeTitle(noticeId);
        notice.setNoticeContent(null);
        notice.setRemark(remark);
        notice.setStatus("2");
        int i1 = noticeService.insertNotice(notice);


        return toAjax(i);
    }

    /**
     * Delete Notice Notice
     */
    @PreAuthorize("@ss.hasPermi('system:notice:remove')")
    @Log(title = "Notice", businessType = BusinessType.DELETE)
    @DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(noticeService.deleteNoticeByIds(noticeIds));
    }
}
