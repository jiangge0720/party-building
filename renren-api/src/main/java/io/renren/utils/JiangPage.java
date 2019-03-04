package io.renren.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/1910:46
 */
public class JiangPage implements Serializable{
    private static final long serialVersionUID = 1L;
    private int code = 0;
    //总记录数
    private int count;
    //列表数据
    private List<?> data;

    public JiangPage(List<?> data, int count) {
        this.data = data;
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}