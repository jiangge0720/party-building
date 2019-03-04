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

package io.renren.modules.demo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.demo.dao.NewsDao;
import io.renren.modules.demo.entity.NewsEntity;
import io.renren.modules.demo.service.NewsService;
import io.renren.modules.sys.dao.SysDictDao;
import io.renren.modules.sys.entity.SysDictEntity;
import io.renren.modules.sys.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        String title = (String)params.get("title");
        String startDate = (String)params.get("startDate");
        String endDate = (String)params.get("endDate");

        Page<NewsEntity> page = this.selectPage(
                new Query<NewsEntity>(params).getPage(),
                new EntityWrapper<NewsEntity>()
                    .like(StringUtils.isNotBlank(title),"title", title)
                    .ge(StringUtils.isNotBlank(startDate),"pub_time", startDate)
                    .le(StringUtils.isNotBlank(endDate),"pub_time", endDate)
        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

}
