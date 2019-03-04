package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-19 14:16:06
 */
public class CategoryBean {
    @Excel(name = "")
    private Long id;
    @Excel(name = "")
    private String name;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
