package io.renren.modules.dangjian.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.excel.CategoryBean;
import io.renren.modules.dangjian.entity.CategoryEntity;
import io.renren.modules.dangjian.service.CategoryService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-19 14:16:06
 */
@RestController
@RequestMapping("dj/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("dangjian:category:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = categoryService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:category:info")
    public R info(@PathVariable("id") Long id){
			CategoryEntity category = categoryService.selectById(id);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:category:save")
    public R save(@RequestBody CategoryEntity category){
			categoryService.insert(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:category:update")
    public R update(@RequestBody CategoryEntity category){
			categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:category:delete")
    public R delete(@RequestBody Long[] ids){
			categoryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 导出
    */
    @RequestMapping("/export")
    @RequiresPermissions("dangjian:category:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        LayuiPage page = categoryService.queryPage(params);

        ExcelUtils.exportExcelToTarget(response, "", page.getData(), CategoryBean.class);
    }

}
