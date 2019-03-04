package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 党支部通知
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-14 15:13:14
 */
@TableName("tb_dept_notification")
public class DeptNotificationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private String state;
	/**
	 * 隶属支部
	 */
	private Long deptId;
	/**
	 * 
	 */
	private Long createdBy;
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
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public String getState() {
		return state;
	}
	/**
	 * 设置：隶属支部
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：隶属支部
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：
	 */
	public Long getCreatedBy() {
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
	public Date getUpdatedAt() {
		return updatedAt;
	}
}
