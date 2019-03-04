package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Exam;
import io.renren.entity.ExamUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/718:48
 */
public interface ExamUserService extends IService<ExamUser> {

    void insertExamUser(ExamUser examUser);

    ExamUser SelectExamWithUser(Long userId) ;
}
