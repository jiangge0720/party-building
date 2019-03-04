package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/1617:30
 */

@Data
@TableName("tb_activity")
public class Activity {

    @TableId
    private Integer id;

    private String title;

    private String content;

    private String type;

    private String participants;

    private Date begTime;

    private Date endTime;

    private Date signDeadlineTime;

    private Date actualEndTime;

    private String state;

    private String taskName;

    private Date taskEndTime;

    private String taskContent;

    private String notificationName;

    private String notificationContent;

    private String createdBy;

    private Date createdAt;

    private Date updatedAt;

    private Integer enrolment;

    private Integer taskState;
}