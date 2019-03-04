package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 党员信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-25 15:00:36
 */
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
	private String xuehao;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 生日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birth;
	/**
	 * 学历
	 */
	private String degree;
	/**
	 * 政治面貌
	 */
	private String politics;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 地址
	 */
	private String nativeplace;

	@TableField(exist = false)
	private List<String> nativeplace1;

	/**
	 * 入党时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date date;

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

	public List<String> getNativeplace1() {
		return nativeplace1;
	}

	public void setNativeplace1(List<String> nativeplace1) {
		this.nativeplace1 = nativeplace1;
	}

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
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：民族
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}
	/**
	 * 获取：民族
	 */
	public String getNation() {
		return nation;
	}
	/**
	 * 设置：生日
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	/**
	 * 获取：生日
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置：学历
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * 获取：学历
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * 设置：政治面貌
	 */
	public void setPolitics(String politics) {
		this.politics = politics;
	}
	/**
	 * 获取：政治面貌
	 */
	public String getPolitics() {
		return politics;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：地址
	 */
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	/**
	 * 获取：地址
	 */
	public String getNativeplace() {
		return nativeplace;
	}
	/**
	 * 设置：入党时间
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：入党时间
	 */
	public Date getDate() {
		return date;
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
