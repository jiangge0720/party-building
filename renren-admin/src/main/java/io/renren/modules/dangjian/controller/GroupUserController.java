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

import io.renren.modules.dangjian.excel.GroupUserBean;
import io.renren.modules.dangjian.entity.GroupUserEntity;
import io.renren.modules.dangjian.service.GroupUserService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 兴趣小组-党员关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:20:20
 */
@RestController
@RequestMapping("dangjian/groupuser")
public class GroupUserController {
    @Autowired
    private GroupUserService groupUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dangjian:groupuser:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = groupUserService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:groupuser:info")
    public R info(@PathVariable("id") Integer id){
			GroupUserEntity groupUser = groupUserService.selectById(id);

        return R.ok().put("groupUser", groupUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:groupuser:save")
    public R save(@RequestBody GroupUserEntity groupUser){
			groupUserService.insert(groupUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:groupuser:update")
    public R update(@RequestBody GroupUserEntity groupUser){
			groupUserService.updateById(groupUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:groupuser:delete")
    public R delete(@RequestBody Integer[] ids){
			groupUserService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 导出
    */
    @RequestMapping("/export")
    @RequiresPermissions("dangjian:groupuser:export")
    public void export(@RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {
        LayuiPage page = groupUserService.queryPage(params);

        ExcelUtils.exportExcelToTarget(response, "兴趣小组-党员关联表", page.getData(), GroupUserBean.class);
    }

}
