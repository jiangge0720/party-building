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
@TableName("tb_comment")
public class Comment {
    @TableId
    private Integer id;
    private String content;
    private String userId;
    private Integer topicId;
    private Date createdDate;
}