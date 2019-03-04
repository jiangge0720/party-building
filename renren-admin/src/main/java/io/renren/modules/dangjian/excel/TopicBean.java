package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 小组话题
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-28 14:19:30
 */
public class TopicBean {
    @Excel(name = "")
    private Long id;
    @Excel(name = "")
    private String title;
    @Excel(name = "")
    private String content;
    @Excel(name = "")
    private Date createdDate;
    @Excel(name = "")
    private Long commentCount;
    @Excel(name = "")
    private Long groupId;
    @Excel(name = "")
    private Long userId;
    @Excel(name = "")
    private String image;
    @Excel(name = "")
    private String state;

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
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
    public Long getCommentCount() {
        return commentCount;
    }
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    public Long getGroupId() {
        return groupId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
