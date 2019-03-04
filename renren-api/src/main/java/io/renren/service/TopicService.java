package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Topic;
import io.renren.utils.JiangPage;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/1916:36
 */
public interface TopicService extends IService<Topic> {
    JiangPage queryPage(Map<String, Object> params);

    void insertTopic(Topic topic);

    void deleteTopic(Topic topic);
}
