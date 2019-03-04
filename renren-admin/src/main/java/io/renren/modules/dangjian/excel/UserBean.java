package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 党员信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-25 15:00:36
 */
public class UserBean {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "学号")
    private String xuehao;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "性别")
    private String sex;
    @Excel(name = "手机号")
    private String phone;
    @Excel(name = "民族")
    private String nation;
    @Excel(name = "生日")
    private Date birth;
    @Excel(name = "学历")
    private String degree;
    @Excel(name = "政治面貌")
    private String politics;
    @Excel(name = "密码")
    private String password;
    @Excel(name = "地址")
    private String nativeplace;
    @Excel(name = "入党时间")
    private Date date;
    @Excel(name = "隶属支部")
    private Integer deptId;
    @Excel(name = "")
    private Integer createdBy;
    @Excel(name = "")
    private Date createdAt;
    @Excel(name = "")
    private Date updatedAt;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }
    public String getXuehao() {
        return xuehao;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public String getNation() {
        return nation;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public Date getBirth() {
        return birth;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getDegree() {
        return degree;
    }
    public void setPolitics(String politics) {
        this.politics = politics;
    }
    public String getPolitics() {
        return politics;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }
    public String getNativeplace() {
        return nativeplace;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public Integer getDeptId() {
        return deptId;
    }
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public Integer getCreatedBy() {
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
