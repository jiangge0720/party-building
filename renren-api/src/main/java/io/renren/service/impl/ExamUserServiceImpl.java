package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.ExamUserDao;
import io.renren.entity.ExamUser;
import io.renren.service.ExamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/718:49
 */
@Service
public class ExamUserServiceImpl extends ServiceImpl<ExamUserDao,ExamUser>implements ExamUserService {

    @Autowired
    private ExamUserDao examUserDao;


    @Override
    public void insertExamUser(ExamUser examUser) {
        examUserDao.insertExamUser(examUser);
    }

    @Override
    public ExamUser SelectExamWithUser(Long userId) {
        return examUserDao.SelectExamWithUser(userId);
    }
}