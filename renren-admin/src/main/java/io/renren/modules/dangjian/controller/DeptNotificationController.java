package io.renren.modules.dangjian.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.excel.DeptNotificationBean;
import io.renren.modules.dangjian.entity.DeptNotificationEntity;
import io.renren.modules.dangjian.service.DeptNotificationService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 党支部通知
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-14 15:13:14
 */
@RestController
@RequestMapping("dj/deptnotify")
public class DeptNotificationController {
    @Autowired
    private DeptNotificationService deptNotificationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dangjian:deptnotify:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = deptNotificationService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:deptnotify:info")
    public R info(@PathVariable("id") Long id){
			DeptNotificationEntity deptNotification = deptNotificationService.selectById(id);

        return R.ok().put("deptNotification", deptNotification);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:deptnotify:save")
    public R save(@RequestBody DeptNotificationEntity deptNotification){
			deptNotificationService.insert(deptNotification);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:deptnotify:update")
    public R update(@RequestBody DeptNotificationEntity deptNotification){
        DeptNotificationEntity origNofity = deptNotificationService.selectById(deptNotification.getId());
        if (Objects.equals(origNofity.getState(), "A")) {
            deptNotificationService.updateById(deptNotification);
            return R.ok();
        } else {
            return R.error("非草稿状态，不能修改");
        }
    }

    /**
     * 发布
     */
    @RequestMapping("/publish")
    @RequiresPermissions("dangjian:deptnotify:update")
    public R publish(@RequestBody DeptNotificationEntity deptNotification){
        deptNotification.setDate(new Date());
        deptNotificationService.updateById(deptNotification);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:deptnotify:delete")
    public R delete(@RequestBody Long[] ids){
			deptNotificationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
