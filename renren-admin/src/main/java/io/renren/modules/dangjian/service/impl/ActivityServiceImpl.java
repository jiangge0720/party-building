package io.renren.modules.dangjian.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.Query;
import io.renren.modules.dangjian.ActivityWithUser;
import io.renren.modules.dangjian.dao.ActivityDao;
import io.renren.modules.dangjian.dao.UserDao;
import io.renren.modules.dangjian.entity.ActivityEntity;
import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.service.ActivityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import io.renren.common.utils.LayuiPage;


@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityDao, ActivityEntity> implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
    @Autowired
    private UserDao userDao;


    @Override
    public LayuiPage queryPage(Map<String, Object> params) {

        String name = (String)params.get("name");
        String startstart = (String)params.get("startstart");
        String startend = (String)params.get("startend");
        String endstart = (String)params.get("endstart");
        String endend = (String)params.get("endend");



                Page<ActivityEntity> page = this.selectPage(
                new Query<ActivityEntity>(params).getPage(),
                new EntityWrapper<ActivityEntity>()
                        .like(StringUtils.isNotBlank(name),"title", name)
                        .ge(StringUtils.isNotBlank(startstart),"beg_time", startstart)
                        .le(StringUtils.isNotBlank(startend),"beg_time", startend)
                        .ge(StringUtils.isNotBlank(endstart),"end_time", endstart)
                        .le(StringUtils.isNotBlank(endend),"end_time", endend)

        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    @Override
    public List<UserEntity> findUser(Long activityId) {
        ActivityEntity activityEntity = activityDao.findUser(activityId);
        ActivityWithUser activityWithUser = new ActivityWithUser();
        BeanUtils.copyProperties(activityEntity,activityWithUser);
        String[] userIds = activityEntity.getParticipants().split(",");
        List<String> stringList = Arrays.asList(userIds);
        List<Integer> userIdList = new ArrayList <>();
        for(String userId : stringList){
            userIdList.add(Integer.parseInt(userId));
        }
        List<UserEntity> userEntities = userDao.selectBatchIds(userIdList);
        activityWithUser.setUserEntities(userEntities);
        return  userEntities;
    }

    @Override
    public void updateActivity(ActivityEntity activityEntity) {
        activityDao.updateActivity(activityEntity);
    }

    ;




}
