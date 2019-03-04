package io.renren.modules.dangjian.entity;

/**
 * @author Jiang-gege
 * 2018/9/219:59
 */
public class Answer {
    private Integer id;
    private String answer;

    public Answer(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}