package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/7/1916:15
 */
@Data
@TableName("tb_topic")
public class Topic {
    @TableId
    private Integer id;
    private String title;
    private String content;
    private Date createdDate;
    private Integer commentCount;
    private Integer groupId;
    private Long userId;
    private String state;
    private String image;
    private Integer likeCount;
    private String userName;

}