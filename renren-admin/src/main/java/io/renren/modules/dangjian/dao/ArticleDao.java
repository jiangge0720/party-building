package io.renren.modules.dangjian.dao;

import io.renren.modules.dangjian.entity.ActivityEntity;
import io.renren.modules.dangjian.entity.ArticleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 文章表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-17 08:54:01
 */
public interface ArticleDao extends BaseMapper<ArticleEntity> {
    ArticleEntity findCategory(Long articleId);

    void updateArticle(ArticleEntity articleEntity);
}
