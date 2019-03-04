package io.renren.modules.dangjian.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * @author Jiang-gege
 * 2018/9/2021:11
 */
@TableName("tb_exam_paper")
public class ExamPaper {
    @TableId
    private Integer paperId;

    private String paperName;

    private Integer paperTotal;

    private Integer paperPass;

    private String paperContent;

    private Integer createdBy;

    private Date createdTime;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getPaperTotal() {
        return paperTotal;
    }

    public void setPaperTotal(Integer paperTotal) {
        this.paperTotal = paperTotal;
    }

    public Integer getPaperPass() {
        return paperPass;
    }

    public void setPaperPass(Integer paperPass) {
        this.paperPass = paperPass;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
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
}

