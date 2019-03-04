package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 党支部通知
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-14 15:13:14
 */
public class DeptNotificationBean {
    @Excel(name = "")
    private Long id;
    @Excel(name = "")
    private String title;
    @Excel(name = "")
    private String content;
    @Excel(name = "")
    private Date date;
    @Excel(name = "")
    private String state;
    @Excel(name = "隶属支部")
    private Long deptId;
    @Excel(name = "")
    private Long createdBy;
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
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
    public Long getDeptId() {
        return deptId;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
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
