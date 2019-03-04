package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.DeptNotification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/208:25
 */
@Mapper
public interface DeptNotificationDao extends BaseMapper<DeptNotification>{

    List<DeptNotification> selectDeptId(@Param("deptId") Long deptId);

}
