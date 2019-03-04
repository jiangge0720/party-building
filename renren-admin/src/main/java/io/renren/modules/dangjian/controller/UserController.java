package io.renren.modules.dangjian.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.modules.dangjian.utils.DataSecurityUtil;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.excel.UserBean;
import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.service.UserService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 党员信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-25 15:00:36
 */
@RestController
@RequestMapping("dj/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("mark:user:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = userService.queryPage(params);

        return page;
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("mark:user:info")
    public R info(@PathVariable("id") Integer id){
			UserEntity user = userService.selectById(id);

        return R.ok().put("data", user);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("mark:user:save")
    public R save(@RequestBody UserEntity user) throws Exception {

//        DataSecurityUtil.setCurrUserInfo(user);

//        user.setNativeplace(objectMapper.writeValueAsString(user.getNativeplace1()));
        // 密码默认为学号后6位
        if (StringUtils.isNotBlank(user.getXuehao())) {
            String xuehao = user.getXuehao();
            user.setPassword(xuehao.substring(xuehao.length() - 6, xuehao.length()));
        }
        userService.insert(user);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("mark:user:update")
    public R update(@RequestBody UserEntity user) throws Exception {
//        DataSecurityUtil.setCurrUserInfo(user);
//        user.setNativeplace(objectMapper.writeValueAsString(user.getNativeplace1()));
        // 密码默认为学号后6位
        user.setPassword(null);
        userService.updateById(user);

        return R.ok();
    }

    @RequestMapping("/resetpassword")
    @RequiresPermissions("mark:user:update")
    public R resetpassword(@RequestBody UserEntity user) throws Exception {
        // 密码默认为学号后6位
        if (StringUtils.isNotBlank(user.getXuehao())) {
            String xuehao = user.getXuehao();
            user.setPassword(xuehao.substring(xuehao.length() - 6, xuehao.length()));
        }
        userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("mark:user:delete")
    public R delete(@RequestBody Integer[] ids){
			userService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
