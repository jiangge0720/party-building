package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.GroupDao;
import io.renren.entity.Group;
import io.renren.entity.Topic;
import io.renren.service.GroupService;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2016:18
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupDao,Group> implements GroupService{

    @Autowired
    private GroupDao groupDao;

    @Override
    public JiangPage queryPage(Map<String, Object> params) {

        String title = (String)params.get("title");

        Page<Group> page = this.selectPage(
                new Query<Group>(params).getPage(),
                new EntityWrapper<Group>()
                        .like(StringUtils.isNotBlank(title),"name", title)
        );
        return new JiangPage(page.getRecords(), page.getTotal());
    }

    @Override
    public void insertGroup(Group group) {
        groupDao.insertGroup(group);
    }
}