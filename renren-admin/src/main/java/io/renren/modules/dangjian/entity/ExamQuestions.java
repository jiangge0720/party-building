package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/2021:22
 */
@TableName("tb_exam_questions")
public class ExamQuestions {
    @TableId
    private Integer questionsId;

    private Integer questionsType;

    private String  questionsContent;

    private String  questionsOption;

    private Integer questionsOptionLen;

    private String  questionsAnswer;

    private String  questionsAnalysis;

    private Integer createdBy;

    private Date createdTime;

    private Integer questionsDifficult;


    public Integer getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Integer questionsId) {
        this.questionsId = questionsId;
    }

    public Integer getQuestionsType() {
        return questionsType;
    }

    public void setQuestionsType(Integer questionsType) {
        this.questionsType = questionsType;
    }

    public String getQuestionsContent() {
        return questionsContent;
    }

    public void setQuestionsContent(String questionsContent) {
        this.questionsContent = questionsContent;
    }

    public String getQuestionsOption() {
        return questionsOption;
    }

    public void setQuestionsOption(String questionsOption) {
        this.questionsOption = questionsOption;
    }

    public Integer getQuestionsOptionLen() {
        return questionsOptionLen;
    }

    public void setQuestionsOptionLen(Integer questionsOptionLen) {
        this.questionsOptionLen = questionsOptionLen;
    }

    public String getQuestionsAnswer() {
        return questionsAnswer;
    }

    public void setQuestionsAnswer(String questionsAnswer) {
        this.questionsAnswer = questionsAnswer;
    }

    public String getQuestionsAnalysis() {
        return questionsAnalysis;
    }

    public void setQuestionsAnalysis(String questionsAnalysis) {
        this.questionsAnalysis = questionsAnalysis;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Integer getQuestionsDifficult() {
        return questionsDifficult;
    }

    public void setQuestionsDifficult(Integer questionsDifficult) {
        this.questionsDifficult = questionsDifficult;
    }

}