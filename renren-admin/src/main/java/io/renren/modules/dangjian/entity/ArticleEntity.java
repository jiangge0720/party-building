package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-17 08:54:01
 */
@TableName("tb_article")
public class ArticleEntity implements Serializable {
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
	 * 栏目类别
	 */
	private String category;
	/**
	 * 
	 */
	private String createdBy;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private Long commentCount;
	/**
	 * 图片
	 */
	private String img;

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
	 * 设置：栏目类别
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：栏目类别
	 */
	public String getCategory() {
		return category;
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy年MM月dd日 HH:mm")
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：
	 */

	public Long getCommentCount() {
		return commentCount;
	}
	/**
	 * 设置：图片
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * 获取：图片
	 */
	public String getImg() {
		return img;
	}
}
