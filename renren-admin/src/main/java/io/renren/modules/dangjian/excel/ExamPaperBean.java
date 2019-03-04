package io.renren.modules.mark.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 试卷表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-21 16:44:00
 */
public class ExamPaperBean {
    @Excel(name = "")
    private Integer paperId;
    @Excel(name = "试卷名称")
    private String paperName;
    @Excel(name = "试卷总分")
    private Integer paperTotal;
    @Excel(name = "试卷及格线")
    private Integer paperPass;
    @Excel(name = "试卷内容")
    private String paperContent;
    @Excel(name = "录入人")
    private Long createdBy;
    @Excel(name = "录入时间")
    private Date createdTime;

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }
    public Integer getPaperId() {
        return paperId;
    }
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
    public String getPaperName() {
        return paperName;
    }
    public void setPaperTotal(Integer paperTotal) {
        this.paperTotal = paperTotal;
    }
    public Integer getPaperTotal() {
        return paperTotal;
    }
    public void setPaperPass(Integer paperPass) {
        this.paperPass = paperPass;
    }
    public Integer getPaperPass() {
        return paperPass;
    }
    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
    }
    public String getPaperContent() {
        return paperContent;
    }
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
    public Date getCreatedTime() {
        return createdTime;
    }
}
