package io.renren.modules.dangjian.service;


import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.ActivityWithUser;
import io.renren.modules.dangjian.entity.ActivityEntity;
import io.renren.modules.dangjian.entity.UserEntity;


import java.util.List;
import java.util.Map;

/**
 * 活动表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-13 09:24:46
 */
public interface ActivityService extends IService<ActivityEntity> {



    LayuiPage queryPage(Map<String, Object> params);

    List<UserEntity> findUser(Long activityId);

    void updateActivity(ActivityEntity activityEntity);

}

