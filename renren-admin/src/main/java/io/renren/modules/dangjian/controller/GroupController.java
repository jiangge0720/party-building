package io.renren.modules.dangjian.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.dangjian.service.DeptService;
import io.renren.modules.dangjian.service.GroupUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.entity.GroupEntity;
import io.renren.modules.dangjian.service.GroupService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.R;


/**
 * 兴趣小组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:14:05
 */
@RestController
@RequestMapping("dj/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupUserService groupUserService;
    @Autowired
    private DeptService deptService;

    //========================== 兴趣小组管理 ==============================
    /**
     * 支部列表，用于选择兴趣小组所在的支部
     */
    @RequestMapping("/deptlist")
    @RequiresPermissions("dangjian:group:list")
    public LayuiPage deptList(@RequestParam Map<String, Object> params){
        LayuiPage page = deptService.queryPage(params);

        return page;
    }

    /**
     * 列表查询，兴趣小组
     */
    @RequestMapping("/list")
    @RequiresPermissions("dangjian:group:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = groupService.queryPage(params);

        return page;
    }

    /**
     * 信息，查看单个小组
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dangjian:group:info")
    public R info(@PathVariable("id") Integer id){
			GroupEntity group = groupService.selectById(id);

        return R.ok().put("group", group);
    }

    /**
     * 保存，新增一个小组
     */
    @RequestMapping("/save")
    @RequiresPermissions("dangjian:group:save")
    public R save(@RequestBody GroupEntity group){
			groupService.insert(group);

        return R.ok();
    }

    /**
     * 修改，更新一个小组
     */
    @RequestMapping("/update")
    @RequiresPermissions("dangjian:group:update")
    public R update(@RequestBody GroupEntity group){
			groupService.updateById(group);

        return R.ok();
    }

    /**
     * 删除小组，连带着删除对应的小组成员关系
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:group:delete")
    public R delete(@RequestBody Long[] ids){
        groupService.deleteGroup(ids);
//			groupService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    //========================== 兴趣小组成员管理 ==============================
    /**
     * 列表查询，兴趣小组成员（已审核通过）
     */
    @RequestMapping("/listgroupuser")
    @RequiresPermissions("dangjian:group:list")
    public LayuiPage listGroupUser(@RequestParam Map<String, Object> params){
        LayuiPage page = groupService.queryGroupUser(params); //groupService.queryGroupUser(params);
        return page;
    }

    /**
     * 列表查询，兴趣小组成员（待审核）
     */
    @RequestMapping("/listgroupuser_toverify")
    @RequiresPermissions("dangjian:group:list")
    public LayuiPage listGroupUserToVerify(@RequestParam Map<String, Object> params){
        LayuiPage page = groupService.queryGroupUserToVerify(params);
        return page;
    }

    /**
     * 删除小组中的成员
     */
    @RequestMapping("/deleteuser")
    @RequiresPermissions("dangjian:group:delete")
    public R deleteGroupUser(@RequestBody Long[] ids) {
        groupUserService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    /*public R deleteGroupUser(@RequestBody Map<String, Object> params) {
        Integer res = groupService.deleteGroupUser(params);
        return R.ok();
    }*/

    /**
     * 审批通过加入小组成员
     */
    @RequestMapping("/approvegroupuser")
    @RequiresPermissions("dangjian:group:update")
    public R approveGroupUserApply(@RequestBody Long[] ids) {
        groupService.approveGroupUserApply(ids);
        return R.ok();
    }

    /**
     * 删除待审批成员
     */
    @RequestMapping("/denygroupuser")
    @RequiresPermissions("dangjian:group:update")
    public R denyGroupUserApply(@RequestBody Long[] ids) {
        groupService.denyGroupUserApply(ids);
        return R.ok();
    }

}
