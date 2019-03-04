package io.renren.modules.dangjian.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.modules.dangjian.dao.ExamQuestionsDao;
import io.renren.modules.dangjian.entity.ExamQuestions;
import io.renren.modules.dangjian.service.ExamQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/2021:25
 */
@Service
public class ExamQuestionsServiceImpl extends ServiceImpl<ExamQuestionsDao,ExamQuestions> implements ExamQuestionsService {

    @Autowired
    private ExamQuestionsDao examQuestionsDao;
    @Override
    public List<ExamQuestions> selectDifficult(Integer questionsDifficult) {
        return examQuestionsDao.selectDifficult(questionsDifficult) ;
    }
}