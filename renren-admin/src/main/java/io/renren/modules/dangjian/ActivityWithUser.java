package io.renren.modules.dangjian;


import io.renren.modules.dangjian.entity.UserEntity;

import java.util.Date;
import java.util.List;

public class ActivityWithUser {
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容简述
     */
    private String content;
    /**     * 活动类型
     */
    private String type;
    /**
     * 参与人员
     */
    private String participants;
    /**
     * 活动起始时间
     */
    private Date begTime;
    /**
     * 活动结束时间
     */
    private Date endTime;
    /**
     * 报名截止时间
     */
    private Date signDeadlineTime;
    /**
     * 实际结束时间(活动结束时间、任务结束时间的最大值)
     */
    private Date actualEndTime;
    /**
     * 状态
     */
    private String state;
    /**
     * 附加任务名字
     */
    private String taskName;
    /**
     * 附加任务结束时间
     */
    private Date taskEndTime;
    /**
     * 附加任务内容
     */
    private String taskContent;
    /**
     * 通知名字
     */
    private String notificationName;
    /**
     * 通知内容
     */
    private String notificationContent;
    /**
     *
     */
    private String createdBy;
    /**
     *
     */
    private Date createdAt;
    /**
     *
     */
    private Date updatedAt;



    private Integer enrolment;

    List<UserEntity> userEntities;
    private  Integer taskState;

    public Integer getTaskState() {
        return taskState;
    }

    public void setTaskState(Integer taskState) {
        this.taskState = taskState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public Date getBegTime() {
        return begTime;
    }

    public void setBegTime(Date begTime) {
        this.begTime = begTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSignDeadlineTime() {
        return signDeadlineTime;
    }

    public void setSignDeadlineTime(Date signDeadlineTime) {
        this.signDeadlineTime = signDeadlineTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List <UserEntity> getUserEntities() {
        return userEntities;
    }

    public Integer getEnrolment() {
        return enrolment;
    }

    public void setEnrolment(Integer enrolment) {
        this.enrolment = enrolment;
    }

    public void setUserEntities(List <UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
