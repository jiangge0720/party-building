package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.ArticleDao;
import io.renren.entity.Article;
import io.renren.service.ArticleService;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2311:06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao,Article> implements ArticleService{

    @Autowired
    ArticleDao articleDao;
    @Override
    public JiangPage queryPage(Map<String, Object> params) {
        String title = (String)params.get("title");
        String startDate = (String)params.get("startDate");
        String endDate = (String)params.get("endDate");

        Page<Article> page = this.selectPage(
                new Query<Article>(params).getPage(),
                new EntityWrapper<Article>()
                        .like(StringUtils.isNotBlank(title),"title", title)
                        .ge(StringUtils.isNotBlank(startDate),"create_time", startDate)
                        .le(StringUtils.isNotBlank(endDate),"create_time", endDate)
        );

        return new JiangPage(page.getRecords(), page.getTotal());
    }

    @Override
    public void insertArticle(Article article) {
        articleDao.insertArticle(article);
    }

    @Override
    public List selectArticle(Integer id) {
        return articleDao.selectArticle(id);
    }
}