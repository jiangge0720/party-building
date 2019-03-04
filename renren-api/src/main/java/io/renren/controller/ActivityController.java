package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.entity.Activity;
import io.renren.entity.UserEntity;
import io.renren.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1617:46
 */
@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping("/list")
    public R activitylist(){

        String type = "1";
        List<Activity> activityList = activityService.selectActivity(type);

        return R.ok().put("activityList",activityList);
    }

    @Login
    @RequestMapping("/baomin")
    public R baomin(@LoginUser UserEntity user,@RequestParam("activityId") Integer activityId){

        Activity activity = activityService.selectById(activityId);
        Long userId = user.getId();


        String participants = activity.getParticipants();


        if(StringUtils.isEmpty(participants)){
            String name = String.valueOf(userId);
            String Participants = participants+name;
            activity.setParticipants(Participants);
        }

        else{

            Integer count = 0;
            String[] arr = participants.split(",");

                for(int i=0; i<arr.length;i++){
                    String name = String.valueOf(userId);
                    if(name.equals(arr[i])){
                        count++;
                    }
                }
                if(count==0) {
                    String name = "," + userId;
                    String Participants = participants + name;
                    activity.setParticipants(Participants);
                }
        }


        activityService.updateById(activity);
        return R.ok();

    }

    @RequestMapping("/count")
    public R activitycount(){
        Integer count = activityService.count();

        return R.ok().put("count",count);
    }
}