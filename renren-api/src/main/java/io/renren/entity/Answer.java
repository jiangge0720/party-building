package io.renren.entity;

import lombok.Data;

/**
 * @author Jiang-gege
 * 2018/9/1614:32
 */
@Data
public class Answer {
    private Integer id;
    private String answer;

    public Answer(){
        super();
    }
}