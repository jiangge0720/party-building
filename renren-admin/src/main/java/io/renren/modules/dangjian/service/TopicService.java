package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.TopicEntity;

import java.util.Map;

/**
 * 小组话题
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-28 14:19:30
 */
public interface TopicService extends IService<TopicEntity> {

    LayuiPage queryPage(Map<String, Object> params);

    void verifyTopic(Long[] ids, String newState);
}

