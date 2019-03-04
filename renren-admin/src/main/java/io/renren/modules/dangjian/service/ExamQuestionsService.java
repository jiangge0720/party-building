package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.dangjian.entity.ExamQuestions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/2021:24
 */
public interface ExamQuestionsService extends IService<ExamQuestions> {

    List<ExamQuestions> selectDifficult( Integer questionsDifficult);
}
