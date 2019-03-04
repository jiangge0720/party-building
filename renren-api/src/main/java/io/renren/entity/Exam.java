package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/712:30
 */
@Data
@TableName("tb_exam")
public class Exam {
    @TableId
    private Integer examId;
    private String examName;
    private Integer examState;
    private String examCover;
    private String examDesc;
    private String paperId;
}