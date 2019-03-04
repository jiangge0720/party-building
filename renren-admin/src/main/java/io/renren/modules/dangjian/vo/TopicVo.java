package io.renren.modules.dangjian.vo;

import io.renren.modules.dangjian.entity.TopicEntity;

public class TopicVo extends TopicEntity {
    private String userName;

    public TopicVo(TopicEntity topicEntity) {
        this.setId(topicEntity.getId());
        this.setTitle(topicEntity.getTitle());
        this.setContent(topicEntity.getContent());
        this.setCreatedDate(topicEntity.getCreatedDate());
        this.setCommentCount(topicEntity.getCommentCount());
        this.setGroupId(topicEntity.getGroupId());
        this.setUserId(topicEntity.getUserId());
        this.setImage(topicEntity.getImage());
        this.setState(topicEntity.getState());
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
