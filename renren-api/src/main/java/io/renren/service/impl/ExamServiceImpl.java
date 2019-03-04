package io.renren.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.dao.ExamDao;
import io.renren.entity.Exam;
import io.renren.service.ExamService;
import io.renren.utils.JiangPage;
import io.renren.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/9/712:44
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamDao,Exam> implements ExamService {

    @Override
    public JiangPage queryPage(Map<String, Object> params) {
        Page<Exam> page = this.selectPage(
                new Query<Exam>(params).getPage(),
                new EntityWrapper<Exam>()
        );

        return new JiangPage(page.getRecords(), page.getTotal());
    }
}