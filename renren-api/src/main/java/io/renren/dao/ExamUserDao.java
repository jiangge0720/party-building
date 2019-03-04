package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.ExamUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/718:46
 */
@Mapper
public interface ExamUserDao extends BaseMapper<ExamUser> {

    void insertExamUser(ExamUser examUser);

    ExamUser SelectExamWithUser(@Param("userId") Long userId);
}
