package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1617:41
 */
@Mapper
public interface ActivityDao extends BaseMapper<Activity> {

    List<Activity> selectActivity(@Param("type") String type);

    Integer count();
}