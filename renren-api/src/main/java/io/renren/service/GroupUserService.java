package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.GroupUser;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/2614:40
 */
public interface GroupUserService extends IService<GroupUser>{

    void insertGroupUser(GroupUser groupUser);

    void deleteGroupUser(GroupUser groupUser);

    List selectMyGroup(Long userId) ;
}
