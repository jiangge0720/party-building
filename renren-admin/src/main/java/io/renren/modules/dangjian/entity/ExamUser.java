package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/2110:49
 */
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

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getUserBegintime() {
        return userBegintime;
    }

    public void setUserBegintime(Date userBegintime) {
        this.userBegintime = userBegintime;
    }

    public Date getUserEndtime() {
        return userEndtime;
    }

    public void setUserEndtime(Date userEndtime) {
        this.userEndtime = userEndtime;
    }

    public String getUserPaperContent() {
        return userPaperContent;
    }

    public void setUserPaperContent(String userPaperContent) {
        this.userPaperContent = userPaperContent;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public Integer getUserIspassed() {
        return userIspassed;
    }

    public void setUserIspassed(Integer userIspassed) {
        this.userIspassed = userIspassed;
    }
}