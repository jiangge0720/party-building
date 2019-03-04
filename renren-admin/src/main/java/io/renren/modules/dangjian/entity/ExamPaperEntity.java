package io.renren.modules.mark.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 试卷表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-21 16:44:00
 */
@TableName("tb_exam_paper")
public class ExamPaperEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer paperId;
	/**
	 * 试卷名称
	 */
	private String paperName;
	/**
	 * 试卷总分
	 */
	private Integer paperTotal;
	/**
	 * 试卷及格线
	 */
	private Integer paperPass;
	/**
	 * 试卷内容
	 */
	private String paperContent;
	/**
	 * 录入人
	 */
	private Long createdBy;
	/**
	 * 录入时间
	 */
	private Date createdTime;

	/**
	 * 设置：
	 */
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	/**
	 * 获取：
	 */
	public Integer getPaperId() {
		return paperId;
	}
	/**
	 * 设置：试卷名称
	 */
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	/**
	 * 获取：试卷名称
	 */
	public String getPaperName() {
		return paperName;
	}
	/**
	 * 设置：试卷总分
	 */
	public void setPaperTotal(Integer paperTotal) {
		this.paperTotal = paperTotal;
	}
	/**
	 * 获取：试卷总分
	 */
	public Integer getPaperTotal() {
		return paperTotal;
	}
	/**
	 * 设置：试卷及格线
	 */
	public void setPaperPass(Integer paperPass) {
		this.paperPass = paperPass;
	}
	/**
	 * 获取：试卷及格线
	 */
	public Integer getPaperPass() {
		return paperPass;
	}
	/**
	 * 设置：试卷内容
	 */
	public void setPaperContent(String paperContent) {
		this.paperContent = paperContent;
	}
	/**
	 * 获取：试卷内容
	 */
	public String getPaperContent() {
		return paperContent;
	}
	/**
	 * 设置：录入人
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * 获取：录入人
	 */
	public Long getCreatedBy() {
		return createdBy;
	}
	/**
	 * 设置：录入时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * 获取：录入时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
}
