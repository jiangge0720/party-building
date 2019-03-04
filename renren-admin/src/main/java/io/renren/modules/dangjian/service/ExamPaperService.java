package io.renren.modules.mark.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.mark.entity.ExamPaperEntity;

import java.util.Map;

/**
 * 试卷表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-21 16:44:00
 */
public interface ExamPaperService extends IService<ExamPaperEntity> {

    LayuiPage queryPage(Map<String, Object> params);
}

