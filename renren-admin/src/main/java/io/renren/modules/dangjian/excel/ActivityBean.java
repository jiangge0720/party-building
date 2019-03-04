package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 活动表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-13 09:24:46
 */
public class ActivityBean {
    @Excel(name = "")
    private Long id;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "内容简述")
    private String content;
    @Excel(name = "活动类型")
    private String type;
    @Excel(name = "参与人员")
    private String participants;
    @Excel(name = "活动起始时间")
    private Date begTime;
    @Excel(name = "活动结束时间")
    private Date endTime;
    @Excel(name = "报名截止时间")
    private Date signDeadlineTime;
    @Excel(name = "实际结束时间(活动结束时间、任务结束时间的最大值)")
    private Date actualEndTime;
    @Excel(name = "状态")
    private String state;
    @Excel(name = "附加任务名字")
    private String taskName;
    @Excel(name = "附加任务结束时间")
    private Date taskEndTime;
    @Excel(name = "附加任务内容")
    private String taskContent;
    @Excel(name = "通知名字")
    private String notificationName;
    @Excel(name = "通知内容")
    private String notificationContent;
    @Excel(name = "")
    private String createdBy;
    @Excel(name = "")
    private Date createdAt;
    @Excel(name = "")
    private Date updatedAt;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public void setParticipants(String participants) {
        this.participants = participants;
    }
    public String getParticipants() {
        return participants;
    }
    public void setBegTime(Date begTime) {
        this.begTime = begTime;
    }
    public Date getBegTime() {
        return begTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void setSignDeadlineTime(Date signDeadlineTime) {
        this.signDeadlineTime = signDeadlineTime;
    }
    public Date getSignDeadlineTime() {
        return signDeadlineTime;
    }
    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }
    public Date getActualEndTime() {
        return actualEndTime;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
    }
    public Date getTaskEndTime() {
        return taskEndTime;
    }
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
    public String getTaskContent() {
        return taskContent;
    }
    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }
    public String getNotificationName() {
        return notificationName;
    }
    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }
    public String getNotificationContent() {
        return notificationContent;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
}
