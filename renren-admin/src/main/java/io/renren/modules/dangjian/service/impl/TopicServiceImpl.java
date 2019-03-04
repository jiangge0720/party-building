package io.renren.modules.dangjian.service.impl;

import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.service.UserService;
import io.renren.modules.dangjian.vo.TopicVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.TopicDao;
import io.renren.modules.dangjian.entity.TopicEntity;
import io.renren.modules.dangjian.service.TopicService;


@Service("topicService")
public class TopicServiceImpl extends ServiceImpl<TopicDao, TopicEntity> implements TopicService {

    @Autowired
    private UserService userService;

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        String selectstate = (String) params.get("selectstate");
        String title = (String) params.get("title");
        String groupId = (String) params.get("groupId");
        String startdate = (String) params.get("startdate");
        String enddate = (String) params.get("enddate");
        String state = (String) params.get("state");

        if (Objects.equals(state, "0")) {
            state = null;
        }
        if (Objects.equals(groupId, "0")) {
            groupId = null;
        }
        Page<TopicEntity> page = this.selectPage(
                new Query<TopicEntity>(params).getPage(),
                new EntityWrapper<TopicEntity>()
                    .eq(StringUtils.isNotBlank(groupId), "group_id", groupId)
                    .eq(StringUtils.isNotBlank(selectstate), "state", selectstate)
                    .like(StringUtils.isNotBlank(title), "title", title)
                    .ge(StringUtils.isNotBlank(startdate), "created_date", startdate)
                    .le(StringUtils.isNotBlank(enddate), "created_date", enddate)
                    .eq(StringUtils.isNotBlank(state), "state", state)
        );

        List<TopicVo> list = new ArrayList<>();
        for (TopicEntity topicEntity : page.getRecords()) {
            TopicVo topicVo = new TopicVo(topicEntity);
            UserEntity userEntity = userService.selectById(topicEntity.getUserId());
            if (userEntity != null) {
                topicVo.setUserName(userEntity.getName());
            }
            list.add(topicVo);
        }
        return new LayuiPage(list, page.getTotal());
    }

    /**
     * 审核话题，通过或驳回
     */
    @Override
    public void verifyTopic(Long[] ids, String newState) {
        for (Long id : ids) {
            TopicEntity topicEntity = new TopicEntity();
            topicEntity.setId(id);
            topicEntity.setState(newState);
            baseMapper.updateById(topicEntity);
        }
    }
}
