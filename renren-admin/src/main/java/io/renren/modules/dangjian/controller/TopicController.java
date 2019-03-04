package io.renren.modules.dangjian.controller;

import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import io.renren.modules.dangjian.Constant.TopicConst;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.dangjian.excel.TopicBean;
import io.renren.modules.dangjian.entity.TopicEntity;
import io.renren.modules.dangjian.service.TopicService;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.R;


/**
 * 小组话题
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-28 14:19:30
 */
@RestController
@RequestMapping("dj/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    /**
     * 话题列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dangjian:group:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = topicService.queryPage(params);

        return page;
    }

    /**
     * 话题审核通过
     */
    @RequestMapping("/approve")
    @RequiresPermissions("dangjian:group:list")
    public R approve(@RequestBody Long[] ids) {
        topicService.verifyTopic(ids, TopicConst.STATE_APPROVED);
        return R.ok();
    }

    /**
     * 活体审核驳回
     */
    @RequestMapping("/deny")
    @RequiresPermissions("dangjian:group:list")
    public R deny(@RequestBody Long[] ids) {
        topicService.verifyTopic(ids, TopicConst.STATE_DENIED);
        return R.ok();
    }


    /**
     * 信息
     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("dangjian:group:info")
//    public R info(@PathVariable("id") Long id){
//			TopicEntity topic = topicService.selectById(id);
//
//        return R.ok().put("topic", topic);
//    }

    /**
     * 保存
     */
//    @RequestMapping("/save")
//    @RequiresPermissions("dangjian:group:save")
//    public R save(@RequestBody TopicEntity topic){
//			topicService.insert(topic);
//
//        return R.ok();
//    }

    /**
     * 修改
     */
//    @RequestMapping("/update")
//    @RequiresPermissions("dangjian:group:update")
//    public R update(@RequestBody TopicEntity topic){
//			topicService.updateById(topic);
//
//        return R.ok();
//    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dangjian:group:delete")
    public R delete(@RequestBody Long[] ids){
			topicService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
