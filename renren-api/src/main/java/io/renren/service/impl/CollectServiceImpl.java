package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.dao.CollectDao;
import io.renren.entity.Article;
import io.renren.entity.Collect;
import io.renren.service.CollectService;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2413:31
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectDao,Collect> implements CollectService{

     @Autowired
    private CollectDao collectDao;

    @Override
    public JiangPage queryPage(Map<String, Object> params) {
        String collectorId = (String)params.get("collectorId");
        if(collectorId == null){
             throw new RRException("articleId必传");
        }
        Page<Collect> page = this.selectPage(
                new Query<Collect>(params).getPage(),
                new EntityWrapper<Collect>()
                        .eq(StringUtils.isNotBlank(collectorId),"name",collectorId)
        );

        return new JiangPage(page.getRecords(), page.getTotal());
    }

    @Override
    public void insertCollect(Collect collect) {
        collectDao.insertCollect(collect);
    }

    @Override
    public int getCollectCount(int articleId) {

        return collectDao.getCollectCount(articleId);
    }

    @Override
    public List selectMyCollect(String userId) {
        return collectDao.selectMyCollect(userId);
    }

    @Override
    public void cancleCollect(int articleId) {
        collectDao.cancleCollect(articleId);
    }
}