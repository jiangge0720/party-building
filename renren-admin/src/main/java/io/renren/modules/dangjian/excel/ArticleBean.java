package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 文章表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-17 08:54:01
 */
public class ArticleBean {
    @Excel(name = "")
    private Long id;
    @Excel(name = "")
    private String title;
    @Excel(name = "")
    private String content;
    @Excel(name = "栏目类别")
    private String category;
    @Excel(name = "")
    private String createdBy;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "修改时间")
    private Date updateTime;
    @Excel(name = "")
    private Long commentCount;
    @Excel(name = "图片")
    private String img;

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
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
    public Long getCommentCount() {
        return commentCount;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getImg() {
        return img;
    }
}
