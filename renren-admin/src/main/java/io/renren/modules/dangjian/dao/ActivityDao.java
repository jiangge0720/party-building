package io.renren.modules.dangjian.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.dangjian.entity.ActivityEntity;

import java.io.Serializable;
import java.util.Map;

/**
 * 活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-13 09:24:46
 */
public interface ActivityDao extends BaseMapper<ActivityEntity> {
    ActivityEntity findUser(Long activityId);

    void updateActivity(ActivityEntity activityEntity);
}
