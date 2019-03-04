package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/2110:37
 */
@TableName("tb_exam")
public class Exam {
    @TableId
    private Integer examId;
    private String examName;
    private Integer examState;
    private Date examBegintime;
    private Date examEndtime;
    private String examDesc;
    private String  paperId;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getExamState() {
        return examState;
    }

    public void setExamState(Integer examState) {
        this.examState = examState;
    }


    public Date getExamBegintime() {
        return examBegintime;
    }

    public void setExamBegintime(Date examBegintime) {
        this.examBegintime = examBegintime;
    }

    public Date getExamEndtime() {
        return examEndtime;
    }

    public void setExamEndtime(Date examEndtime) {
        this.examEndtime = examEndtime;
    }

    public String getExamDesc() {
        return examDesc;
    }

    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String  paperId) {
        this.paperId = paperId;
    }
}