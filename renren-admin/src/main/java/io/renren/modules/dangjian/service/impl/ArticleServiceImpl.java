package io.renren.modules.dangjian.service.impl;



import io.renren.modules.dangjian.ArticleWithCategory;
import io.renren.modules.dangjian.dao.CategoryDao;


import io.renren.modules.dangjian.entity.CategoryEntity;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.ArticleDao;
import io.renren.modules.dangjian.entity.ArticleEntity;
import io.renren.modules.dangjian.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        String category = (String)params.get("category");
        String name = (String)params.get("name");
        String startdate = (String)params.get("startdate");
        String enddate = (String)params.get("enddate");
        Page<ArticleEntity> page = new Page <>();

        if(Objects.equals(category, "0")){
            category = null;
        }
        page = this.selectPage(
                new Query<ArticleEntity>(params).getPage(),
                new EntityWrapper<ArticleEntity>()
                        .like(StringUtils.isNotBlank(category),"category", category)
                        .like(StringUtils.isNotBlank(name),"title", name)
                        .ge(StringUtils.isNotBlank(startdate),"create_time", startdate)
                        .le(StringUtils.isNotBlank(enddate),"create_time", enddate)


        );
        /*if(category.equals("0")){
             page = this.selectPage(
                    new Query<ArticleEntity>(params).getPage(),
                    new EntityWrapper<ArticleEntity>()
            );}*/

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    @Override
    public List <CategoryEntity> findCategory(Long activityId) {
        ArticleEntity articleEntity = articleDao.findCategory(activityId);
        ArticleWithCategory articleWithCategory = new ArticleWithCategory();
        BeanUtils.copyProperties(articleEntity,articleWithCategory);
        String[] categoryIds = articleEntity.getCategory().split(",");
        List<String> stringList = Arrays.asList(categoryIds);
        List<Integer> categoryIdList = new ArrayList <>();
        for(String categoryId : stringList){
            categoryIdList.add(Integer.parseInt(categoryId));
        }
        List<CategoryEntity> categoryEntities = categoryDao.selectBatchIds(categoryIdList);
        articleWithCategory.setCategoryEntities(categoryEntities);
        return  categoryEntities;
    }

    @Override
    public void updateArticle(ArticleEntity articleEntity) {
        articleDao.updateArticle(articleEntity);
    }

    ;

}
