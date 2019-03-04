package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.ActivityDao;
import io.renren.entity.Activity;
import io.renren.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1617:44
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityDao,Activity>implements ActivityService{

    @Autowired
    private ActivityDao activityDao;

    @Override
    public List<Activity> selectActivity(String type) {
        return activityDao.selectActivity(type);
    }

    @Override
    public Integer count() {
        return activityDao.count();
    }
}