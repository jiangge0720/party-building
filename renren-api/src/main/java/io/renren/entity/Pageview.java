package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/1816:02
 */
@Data
@TableName("tb_pageview")
public class Pageview {
    @TableId
    private Integer id;

    private String ip;

    private Date createTime;
}