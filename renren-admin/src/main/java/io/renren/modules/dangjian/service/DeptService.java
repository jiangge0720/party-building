package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.DeptEntity;

import java.util.Map;

public interface DeptService extends IService<DeptEntity> {

  LayuiPage queryPage(Map<String, Object> params);

}
