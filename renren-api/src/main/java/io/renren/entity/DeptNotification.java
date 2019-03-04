package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/208:16
 */
@Data
@TableName("tb_dept_notification")
public class DeptNotification {
    @TableId

    private Integer id;

    private String title;

    private String content;

    private Date date;

    private String state;

    private Long deptId;

    private Integer createdBy;

    private Date createdAt;

    private Date updatedAt;
}