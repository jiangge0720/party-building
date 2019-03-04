package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/1415:15
 */
@Data
@TableName("tb_exam_paper")
public class ExamPaper {
    @TableId
    private Integer paperId;

    private String paperName;

    private Integer paperTotal;

    private Integer paperPass;

    private String paperContent;

    private Date createdTime;
}