package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 兴趣小组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:14:05
 */
public class GroupBean {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "小组名字")
    private String name;
    @Excel(name = "建立时间")
    private Date date;
    @Excel(name = "简介")
    private String content;
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
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
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
