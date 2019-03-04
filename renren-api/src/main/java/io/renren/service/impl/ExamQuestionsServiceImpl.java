package io.renren.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.ExamQuestionsDao;
import io.renren.entity.ExamQuestions;
import io.renren.service.ExamQuestionsService;
import org.springframework.stereotype.Service;

/**
 * @author Jiang-gege
 * 2018/9/1415:37
 */
@Service
public class ExamQuestionsServiceImpl extends ServiceImpl<ExamQuestionsDao,ExamQuestions>implements ExamQuestionsService {
}