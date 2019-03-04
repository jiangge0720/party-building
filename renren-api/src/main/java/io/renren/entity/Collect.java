package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/7/2315:55
 */
@Data
@TableName("tb_collect")
public class Collect {
    @TableId
    private Integer id;
    private Integer articleId;
    private String collectorId;
    private Date createdDate;
}