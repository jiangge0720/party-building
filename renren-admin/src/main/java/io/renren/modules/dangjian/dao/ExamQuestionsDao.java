package io.renren.modules.dangjian.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.dangjian.entity.ExamQuestions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/2021:23
 */
@Mapper
public interface ExamQuestionsDao extends BaseMapper<ExamQuestions> {
    List<ExamQuestions>selectDifficult(@Param("questionsDifficult") Integer questionsDifficult);
}
