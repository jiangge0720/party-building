package io.renren.modules.dangjian.vo;

import io.renren.modules.dangjian.entity.UserEntity;

public class GroupUserVo extends UserEntity {
    private Long groupUserId;
    private Long groupId;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getGroupUserId() {
        return groupUserId;
    }

    public void setGroupUserId(Long groupUserId) {
        this.groupUserId = groupUserId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
