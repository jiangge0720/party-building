package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-13 09:24:46
 */
@TableName("tb_activity")
public class ActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容简述
	 */
	private String content;
	/**
	 * 活动类型
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

	private Integer enrolment;

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
	/**
	 * 设置：
	 */
private  Integer taskState;

	public Integer getTaskState() {
		return taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	public Integer getEnrolment() {
		return enrolment;
	}

	public void setEnrolment(Integer enrolment) {
		this.enrolment = enrolment;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容简述
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容简述
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：活动类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：活动类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：参与人员
	 */
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	/**
	 * 获取：参与人员
	 */
	public String getParticipants() {
		return participants;
	}
	/**
	 * 设置：活动起始时间
	 */
	public void setBegTime(Date begTime) {
		this.begTime = begTime;
	}
	/**
	 * 获取：活动起始时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getBegTime() {
		return begTime;
	}
	/**
	 * 设置：活动结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：活动结束时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：报名截止时间
	 */
	public void setSignDeadlineTime(Date signDeadlineTime) {
		this.signDeadlineTime = signDeadlineTime;
	}
	/**
	 * 获取：报名截止时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getSignDeadlineTime() {
		return signDeadlineTime;
	}
	/**
	 * 设置：实际结束时间(活动结束时间、任务结束时间的最大值)
	 */
	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}
	/**
	 * 获取：实际结束时间(活动结束时间、任务结束时间的最大值)
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getActualEndTime() {
		return actualEndTime;
	}
	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：附加任务名字
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	/**
	 * 获取：附加任务名字
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * 设置：附加任务结束时间
	 */
	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	/**
	 * 获取：附加任务结束时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getTaskEndTime() {
		return taskEndTime;
	}
	/**
	 * 设置：附加任务内容
	 */
	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}
	/**
	 * 获取：附加任务内容
	 */
	public String getTaskContent() {
		return taskContent;
	}
	/**
	 * 设置：通知名字
	 */


	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}
	/**
	 * 获取：通知名字
	 */
	public String getNotificationName() {
		return notificationName;
	}
	/**
	 * 设置：通知内容
	 */
	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}
	/**
	 * 获取：通知内容
	 */
	public String getNotificationContent() {
		return notificationContent;
	}
	/**
	 * 设置：
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * 设置：
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * 获取：
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * 设置：
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * 获取：
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getUpdatedAt() {
		return updatedAt;
	}
}
