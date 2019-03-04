package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.ActivityEntity;
import io.renren.modules.dangjian.entity.ArticleEntity;
import io.renren.modules.dangjian.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 文章表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-17 08:54:01
 */
public interface ArticleService extends IService<ArticleEntity> {

    LayuiPage queryPage(Map<String, Object> params);
    List <CategoryEntity> findCategory(Long articleId);
    void updateArticle(ArticleEntity articleEntity);

}

