package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

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
public class Group implements Serializable {
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
    private Date date;
    /**
     * 简介
     */
    private String content;
    /**
     * 隶属支部
     */
    private Integer deptId;
    /**
     *
     */
    private Integer createdBy;
    /**
     *
     */
    private Date createdAt;
    /**
     *
     */
    private Date updatedAt;

    private String image;

    /**
     * 设置：
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    /**
     * 获取：隶属支部
     */
    public Integer getDeptId() {
        return deptId;
    }
    /**
     * 设置：
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    /**
     * 获取：
     */
    public Integer getCreatedBy() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
