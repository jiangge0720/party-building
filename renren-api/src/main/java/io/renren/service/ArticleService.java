package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.R;
import io.renren.entity.Article;
import io.renren.utils.JiangPage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/1710:53
 */
public interface ArticleService extends IService<Article> {
    JiangPage queryPage(Map<String, Object> params);

    void insertArticle(Article article);

    List selectArticle(Integer id);
}
