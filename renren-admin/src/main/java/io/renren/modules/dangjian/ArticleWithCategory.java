package io.renren.modules.dangjian;


import io.renren.modules.dangjian.entity.CategoryEntity;
import io.renren.modules.dangjian.entity.UserEntity;

import java.util.Date;
import java.util.List;

public class ArticleWithCategory {
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
    List<CategoryEntity> categoryEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List <CategoryEntity> getCategoryEntities() {
        return categoryEntities;
    }

    public void setCategoryEntities(List <CategoryEntity> categoryEntities) {
        this.categoryEntities = categoryEntities;
    }
}
