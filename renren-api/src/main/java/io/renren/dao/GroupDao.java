package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Group;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jiang-gege
 * 2018/7/2016:16
 */
@Mapper
public interface GroupDao extends BaseMapper<Group> {
    void insertGroup(Group group);
}
