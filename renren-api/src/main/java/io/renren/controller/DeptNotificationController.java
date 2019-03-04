package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.entity.DeptNotification;
import io.renren.entity.UserEntity;
import io.renren.service.DeptNotificationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/208:31
 */
@RestController
@RequestMapping("/api/DeptNotification")
public class DeptNotificationController {

    @Autowired
    private DeptNotificationService deptNotificationService;

    @Login
    @RequestMapping("/mylist")
    public R mylist(@LoginUser UserEntity user){

        Long deptId = user.getDeptId();

        List<DeptNotification> deptNotificationlist = deptNotificationService.selectDeptId(deptId);

        List<DeptNotification> deptNotificationList1 = new ArrayList<>();
        for(DeptNotification deptNotification:deptNotificationlist){
            if(deptNotification.getState().equals("A")){
                deptNotificationList1.add(deptNotification);
            }
        }

        return R.ok().put("deptNotificationList",deptNotificationList1);
    }


}