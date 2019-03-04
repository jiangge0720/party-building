package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.GroupUserDao;
import io.renren.entity.GroupUser;
import io.renren.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/2614:46
 */
@Service
public class GroupUserServiceImpl extends ServiceImpl<GroupUserDao,GroupUser> implements GroupUserService{

    @Autowired
    private GroupUserDao groupUserDao;

    @Override
    public void insertGroupUser(GroupUser groupUser) {
        groupUserDao.insertGroupUser(groupUser);
    }

    @Override
    public void deleteGroupUser(GroupUser groupUser) {
        groupUserDao.deleteGroupUser(groupUser);
    }


    @Override
    public List selectMyGroup(Long userId) {
        return groupUserDao.selectMyGroup(userId);
    }
}