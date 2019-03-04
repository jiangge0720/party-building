package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.PageviewDao;
import io.renren.entity.Pageview;
import io.renren.service.PageviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1816:10
 */
@Service
public class pageviewServiceImpl extends ServiceImpl<PageviewDao,Pageview> implements PageviewService{

    @Autowired
    private PageviewDao pageviewDao;

    @Override
    public List<Pageview> selectIp(String ip) {
        return pageviewDao.selectIp(ip);
    }

    @Override
    public void insertPageview(Pageview pageview) {
         pageviewDao.insertPageview(pageview);
    }

    @Override
    public Integer count() {
        return pageviewDao.count();
    }

    @Override
    public List<Pageview> selectAll() {
        return pageviewDao.selectAll();
    }

    @Override
    public Integer topiccount() {
        return pageviewDao.topiccount();
    }
}