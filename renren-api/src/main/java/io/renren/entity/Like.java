package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/1113:56
 */
@Data
@TableName("tb_like")
public class Like {

    @TableId
    private Integer id;

    private Integer topicId;

    private Long userId;

    private Date createdDate;
}