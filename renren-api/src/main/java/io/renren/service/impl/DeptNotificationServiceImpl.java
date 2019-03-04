package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.DeptNotificationDao;
import io.renren.entity.DeptNotification;
import io.renren.service.DeptNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/208:29
 */
@Service
public class DeptNotificationServiceImpl extends ServiceImpl<DeptNotificationDao,DeptNotification>implements DeptNotificationService{

    @Autowired
    private DeptNotificationDao deptNotificationDao;


    @Override
    public List<DeptNotification> selectDeptId(Long deptId) {
        return deptNotificationDao.selectDeptId(deptId);
    }
}