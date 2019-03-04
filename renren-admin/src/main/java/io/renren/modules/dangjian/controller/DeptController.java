package io.renren.modules.dangjian.controller;

import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.R;
import io.renren.modules.dangjian.entity.DeptEntity;
import io.renren.modules.dangjian.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/dj/dept")
public class DeptController {

  @Autowired
  private DeptService deptService;

  /**
   * 列表查询
   */
  @RequestMapping("/list")
  @RequiresPermissions("sys:dept:list")
  public LayuiPage list(@RequestParam Map<String, Object> params){
    LayuiPage page = deptService.queryPage(params);

    return page;
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("sys:dept:save")
  public R save(@RequestBody DeptEntity deptEntity) throws Exception {
    deptEntity.setParentId(1L);
    deptEntity.setOrderNum(0);
    deptEntity.setDelFlag(0);
    deptEntity.setDate(new Date());
    deptService.insert(deptEntity);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("sys:dept:update")
  public R update(@RequestBody DeptEntity deptEntity) throws Exception {
    deptService.updateById(deptEntity);
    return R.ok();
  }

  /**
   * 批量删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("sys:dept:delete")
  public R delete(@RequestBody Integer[] ids){
    deptService.deleteBatchIds(Arrays.asList(ids));

    return R.ok();
  }
}
