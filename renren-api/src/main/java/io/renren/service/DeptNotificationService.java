package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.DeptNotification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/208:28
 */
public interface DeptNotificationService extends IService<DeptNotification>{

    List<DeptNotification> selectDeptId( Long deptId);
}
