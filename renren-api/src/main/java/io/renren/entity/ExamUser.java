package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/718:31
 */
@Data
@TableName("tb_exam_user")
public class ExamUser {
    @TableId
    private Integer examId;
    private Long userId;
    private Date userBegintime;
    private Date userEndtime;
    private String userPaperContent;
    private Integer userScore;
    private Integer userIspassed;
}