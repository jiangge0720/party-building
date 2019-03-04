package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.TopicDao;
import io.renren.entity.Article;
import io.renren.entity.Topic;
import io.renren.service.TopicService;
import io.renren.service.WebSocket;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/1916:44
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicDao,Topic> implements TopicService{

    @Autowired
    private TopicDao topicDao;


    @Autowired
    private WebSocket webSocket;


    @Override
    public JiangPage queryPage(Map<String, Object> params) {
        String title = (String)params.get("title");
        String startDate = (String)params.get("startDate");
        String endDate = (String)params.get("endDate");

        Page<Topic> page = this.selectPage(
                new Query<Topic>(params).getPage(),
                new EntityWrapper<Topic>()
                        .like(StringUtils.isNotBlank(title),"title", title)
                        .ge(StringUtils.isNotBlank(startDate),"create_time", startDate)
                        .le(StringUtils.isNotBlank(endDate),"create_time", endDate)
        );

        return new JiangPage(page.getRecords(), page.getTotal());
    }

    @Override
    public void insertTopic(Topic topic) {
        topicDao.insertTopic(topic);
    }

    @Override
    public void deleteTopic(Topic topic) {

            topicDao.deleteTopic(topic);

    }
}