package io.renren.controller;

import io.renren.annotation.Login;
import io.renren.annotation.LoginUser;
import io.renren.common.utils.R;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Article;
import io.renren.entity.Collect;
import io.renren.entity.UserEntity;
import io.renren.service.ArticleService;
import io.renren.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2413:36
 */
@RestController
@RequestMapping("/api/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @Login
    @RequestMapping("/mylist")
    public R list(@LoginUser UserEntity user){
        String userId = user.getXuehao();
        List collectlist= collectService.selectMyCollect(userId);
        return R.ok().put("collectlist",collectlist);
    }


//    /**
//     * 查询文章收藏数量
//     */
//    @RequestMapping("/collectcount")
//    public R findOne(@RequestParam("articleId") int articleId){
//        Integer collectcount = collectService.getCollectCount(articleId);
//        return R.ok().put("collectcount",collectcount);
//    }


    /**
     * 添加收藏
     */
    @Login
    @RequestMapping("/add")
    public R add(HttpServletRequest request, @LoginUser UserEntity user){

        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
        Integer articleId = Integer.parseInt(orgRequest.getParameter("articleId"));
        String collectorId = user.getXuehao();

        Collect entity = new Collect();
        Article article = articleService.selectById(articleId);
        Integer articlecount = article.getCollectCount();
        entity.setArticleId(articleId);
        entity.setCollectorId(collectorId);
        article.setCollectCount(articlecount+1);

        collectService.insertCollect(entity);
        articleService.updateById(article);

        return R.ok();
    }

    /**
     * 取消收藏
     */
    @Login
    @RequestMapping("/cancel")
    public R cancel(@RequestParam("articleId") int articleId , @LoginUser UserEntity user){
        Article article = articleService.selectById(articleId);
        //Collect collect = collectService.selectById(articleId);
        Integer collectCount = article.getCollectCount();
        article.setCollectCount(collectCount-1);
        articleService.updateById(article);
        collectService.cancleCollect(articleId);

        return R.ok();
    }

}