package io.renren.modules.dangjian.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;


import io.renren.modules.dangjian.ActivityWithUser;
import io.renren.modules.dangjian.entity.ActivityEntity;
import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.excel.ActivityBean;
import io.renren.modules.dangjian.service.ActivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;

import static io.renren.common.utils.FileUitl.isDateAfter;
import static io.renren.common.utils.FileUitl.isDateBefore;


/**
 * 活动表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-13 09:24:46
 */
@RestController
@RequestMapping("dj/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
  @RequiresPermissions("dangjian:activity:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){

        LayuiPage page = activityService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:activity:info")
    public R info(@PathVariable("id") Long id){
			ActivityEntity activity = activityService.selectById(id);

        return R.ok().put("data", activity);
    }

    @RequestMapping("/userinfo/{id}")
    @RequiresPermissions("dangjian:activity:info")
    public R userinfo(@PathVariable("id") Long id){
        List<UserEntity> activity = activityService.findUser(id);

        return R.ok().put("data", activity);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:activity:save")
    public R save(@RequestBody ActivityEntity activity){
		if(Objects.equals(activity.getTaskName(), "")){
		    activity.setTaskState(0);
        }else{
            activity.setTaskState(1);
        }

//        SimpleDateFormat df = new SimpleDateFormat("");//设置日期格式
       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date ten = null;
//        Date now = null;
        String date1=format.format(new Date());
        String date2= format.format(activity.getBegTime());
        String date3= format.format(activity.getEndTime());
        boolean isbefore = isDateBefore(date1,date2);
        boolean isafter1 = isDateAfter(date1,date2);
        boolean isbefore1 = isDateBefore(date1,date3);
        boolean isafter = isDateAfter(date1,date3);
        if(isbefore)
        {
            activity.setState("未开始");
            System.out.println("未开始");
        }
        if(isafter)
        {
            activity.setState("已结束");
            System.out.println("已结束");
        }
        if (isbefore1 && isafter1)
        {
            activity.setState("进行中");
            System.out.println("进行中");
        }



        activityService.insert(activity);


        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:activity:update")
    public R update(@RequestBody ActivityEntity activity){

        if(Objects.equals(activity.getTaskName(), "")){
            activity.setTaskState(0);
        }else{
            activity.setTaskState(1);
    }
//        if (activity.getTaskName().equals("")){
//            activity.setTaskName("");
//        }


//        if(activity.getTaskName().equals("")){
//            activity.setTaskState(0);
//        }else{
//            activity.setTaskState(1);
//        }

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        Date ten = null;
////        Date now = null;
//        String date1=format.format(new Date());
//        String date2= format.format(activity.getBegTime());
//        String date3= format.format(activity.getEndTime());
//        boolean isbefore = isDateBefore(date1,date2);
//        boolean isafter1 = isDateAfter(date1,date2);
//        boolean isbefore1 = isDateBefore(date1,date3);
//        boolean isafter = isDateAfter(date1,date3);
//        if(isbefore)
//        {
//            activity.setState("未开始");
//            System.out.println("未开始");
//        }
//        if(isafter)
//        {
//            activity.setState("已结束");
//            System.out.println("已结束");
//        }
//        if (isbefore1 && isafter1)
//        {
//            activity.setState("进行中");
//            System.out.println("进行中");
//        }

			activityService.updateActivity(activity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:activity:delete")
    public R delete(@RequestBody Long[] ids){
			activityService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 导出
    */
    @RequestMapping("/export")
    @RequiresPermissions("mark:activity:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        LayuiPage page = activityService.queryPage(params);

        ExcelUtils.exportExcelToTarget(response, "活动表", page.getData(), ActivityBean.class);
    }


}
