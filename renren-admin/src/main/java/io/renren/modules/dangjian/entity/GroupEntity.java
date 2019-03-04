package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 兴趣小组
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:14:05
 */
@TableName("tb_group")
public class GroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 小组名字
	 */
	private String name;
	/**
	 * 建立时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;
	/**
	 * 简介
	 */
	private String content;
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
	 * 设置：小组名字
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：小组名字
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：建立时间
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：建立时间
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：简介
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：简介
	 */
	public String getContent() {
		return content;
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
