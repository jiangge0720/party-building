package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Group;
import io.renren.entity.GroupUser;
import io.renren.entity.UserEntity;
import io.renren.service.GroupService;
import io.renren.service.GroupUserService;
import io.renren.utils.JiangPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2016:17
 */
@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupUserService groupUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public JiangPage list(@RequestParam Map<String, Object> params) {
        JiangPage page = groupService.queryPage(params);

        return page;
    }

    /**
     * 我的列表
     */
    @Login
    @RequestMapping("/mylist")
    public R list(@LoginUser UserEntity user){
        Long userId = user.getId();
        List grouplist= groupUserService.selectMyGroup(userId);
        return R.ok().put("grouplist",grouplist);
    }


//    /**
//     * 查询小組
//     */
//    @RequestMapping("/findOne")
//    public R findOne(@RequestParam("id") String id) {
//        Group group = groupService.selectById(id);
//        return R.ok().put("group", group);
//    }


    /**
     * 加入兴趣小组
     */
    @Login
    @PostMapping("/join")
    public R add(@RequestParam("groupId") Long groupId, @LoginUser UserEntity user) {
    //public R add(@RequestBody Long groupId, @LoginUser UserEntity user) {

         Long userId = user.getId();

        GroupUser entity = new GroupUser();
        entity.setUserId(userId);
        entity.setGroupId(groupId);
        entity.setStatus("A");

        groupUserService.insertGroupUser(entity);

        return R.ok("待审核");
    }

    /**
     * 退出兴趣小组
     */
    @Login
    @RequestMapping("/delete")
    public R delete(@RequestParam("id") Long id) {
        GroupUser groupUser = groupUserService.selectById(id);
        groupUserService.deleteGroupUser(groupUser);
        return R.ok();
    }
}