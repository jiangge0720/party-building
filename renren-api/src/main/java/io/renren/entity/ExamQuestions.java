package io.renren.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/1415:20
 */
@Data
@TableName("tb_exam_questions")
public class ExamQuestions {
    @TableId
    private Integer questionsId;

    private Integer questionsType;

    private String  questionsContent;

    private String  questionsOption;

    private String  questionsAnswer;

    private String  questionsAnalysis;

    private Date    createdTime;

    private Integer questionsDifficult;

}