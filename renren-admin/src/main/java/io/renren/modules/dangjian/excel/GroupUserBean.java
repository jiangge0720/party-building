package io.renren.modules.dangjian.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 兴趣小组-党员关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:20:20
 */
public class GroupUserBean {
    @Excel(name = "")
    private Integer id;
    @Excel(name = "党员ID")
    private Integer userId;
    @Excel(name = "兴趣小组ID")
    private Integer deptId;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public Integer getDeptId() {
        return deptId;
    }
}
