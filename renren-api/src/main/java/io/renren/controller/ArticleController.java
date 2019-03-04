package io.renren.controller;
import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.common.xss.XssHttpServletRequestWrapper;
import io.renren.entity.Article;
import io.renren.service.ArticleService;
import io.renren.utils.IdUtils;
import io.renren.utils.JiangPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/1714:29
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public JiangPage list(@RequestParam Map<String, Object> params){
        JiangPage page = articleService.queryPage(params);

        return page;
    }


    /**
     * 查询文章详细信息
     */
    @RequestMapping("/findOne")
    public R findone(@RequestParam("id") int id){
        List articlelist = articleService.selectArticle(id);
        return R.ok().put("articlelist",articlelist);
    }


    /**
     * 发布文章
     */
//    @RequestMapping("/add")
//    public R add (HttpServletRequest request){
//        String ArticleId = IdUtils.genUniqueKey();
//        HttpServletRequest orgRequest = XssHttpServletRequestWrapper.getOrgRequest(request);
//        String title = orgRequest.getParameter("title");
//        String content = orgRequest.getParameter("content");
//        String category = orgRequest.getParameter("category");
//
//
//        Assert.isBlank(title, "标题不能为空");
//        Assert.isBlank(content, "内容不能为空");
//        Assert.isBlank(category, "发布类目不能为空");
//
//        Article entity = new Article();
//        entity.setId(ArticleId);
//        entity.setTitle(title);
//        entity.setContent(content);
//        entity.setCategory(category);
//        entity.setCommentCount(0);
//        entity.setCreatedBy("朱李江");
//
//        articleService.insertArticle(entity);
//
//        return R.ok();
//    }


    /**
     * 查询文章
     */


//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestParam("id")String id){
//        articleService.deleteById(id);
//        return R.ok();
//    }



}
