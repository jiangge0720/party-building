/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.modules.demo.controller;

import io.renren.common.utils.DateUtils;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.modules.demo.entity.NewsEntity;
import io.renren.modules.demo.service.NewsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 新闻
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-01-27
 */
@RestController
@RequestMapping("demo/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("demo:news:list")
    public LayuiPage list(@RequestParam Map<String, Object> params){
        LayuiPage page = newsService.queryPage(params);

        return page;
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:news:info")
    public R info(@PathVariable("id") Long id){
        NewsEntity news = newsService.selectById(id);

        return R.ok().put("news", news);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("demo:news:save")
    public R save(HttpServletRequest request){
        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        String title = orgRequest.getParameter("title");
        String content = orgRequest.getParameter("content");
        String pubTime = orgRequest.getParameter("pubTime");

        Assert.isBlank(title, "标题不能为空");
        Assert.isBlank(content, "内容不能为空");
        Assert.isBlank(pubTime, "发布时间不能为空");

        NewsEntity entity = new NewsEntity();
        entity.setTitle(title);
        entity.setContent(content);
        entity.setPubTime(DateUtils.parse(pubTime, DateUtils.DATE_TIME_PATTERN));
        entity.setCreateDate(new Date());

        newsService.insert(entity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:news:update")
    public R update(HttpServletRequest request){
        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        String id = orgRequest.getParameter("id");
        String title = orgRequest.getParameter("title");
        String content = orgRequest.getParameter("content");
        String pubTime = orgRequest.getParameter("pubTime");

        Assert.isBlank(id, "ID不能为空");
        Assert.isBlank(title, "标题不能为空");
        Assert.isBlank(content, "内容不能为空");
        Assert.isBlank(pubTime, "发布时间不能为空");

        NewsEntity entity = new NewsEntity();
        entity.setId(Long.parseLong(id));
        entity.setTitle(title);
        entity.setContent(content);
        entity.setPubTime(DateUtils.parse(pubTime, DateUtils.DATE_TIME_PATTERN));

        newsService.updateById(entity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("demo:news:delete")
    public R delete(@RequestBody Long[] ids){
        newsService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
