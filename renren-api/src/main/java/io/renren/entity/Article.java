package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Jiang-gege
 * 2018/7/179:42
 */
@TableName("tb_article")
public class Article implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private String title;

    private String content;

    private String category;

    private String createdBy;

    private Date createTime;

    private Date updateTime;

    private String img;

    private Integer collectCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }
}