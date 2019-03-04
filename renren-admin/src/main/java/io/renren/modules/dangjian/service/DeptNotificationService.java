package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.DeptNotificationEntity;

import java.util.Map;

/**
 * 党支部通知
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-14 15:13:14
 */
public interface DeptNotificationService extends IService<DeptNotificationEntity> {

    LayuiPage queryPage(Map<String, Object> params);
}

