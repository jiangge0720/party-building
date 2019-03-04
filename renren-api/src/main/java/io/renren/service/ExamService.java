package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Exam;
import io.renren.utils.JiangPage;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/9/712:42
 */
public interface ExamService extends IService<Exam> {

    JiangPage queryPage(Map<String, Object> params);

}
