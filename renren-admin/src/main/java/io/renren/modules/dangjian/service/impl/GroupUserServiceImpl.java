package io.renren.modules.dangjian.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.GroupUserDao;
import io.renren.modules.dangjian.entity.GroupUserEntity;
import io.renren.modules.dangjian.service.GroupUserService;


@Service("groupUserService")
public class GroupUserServiceImpl extends ServiceImpl<GroupUserDao, GroupUserEntity> implements GroupUserService {

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        Page<GroupUserEntity> page = this.selectPage(
                new Query<GroupUserEntity>(params).getPage(),
                new EntityWrapper<GroupUserEntity>()
        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

}
