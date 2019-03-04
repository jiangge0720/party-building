package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.GroupUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/7/2614:38
 */
@Mapper
public interface GroupUserDao extends BaseMapper<GroupUser>{
    void insertGroupUser(GroupUser groupUser);
    void deleteGroupUser(GroupUser groupUser);
    List selectMyGroup(@Param("userId") Long userId);
}