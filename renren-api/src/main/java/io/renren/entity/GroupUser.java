package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 兴趣小组-党员关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:20:20
 */
@TableName("tb_group_user")
public class GroupUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Integer id;
    /**
     * 党员ID
     */
    private Long userId;
    /**
     * 兴趣小组ID
     */
    private Long groupId;

    private String status;

    private String image;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 设置：党员ID
     */



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
