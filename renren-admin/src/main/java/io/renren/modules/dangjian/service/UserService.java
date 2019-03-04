package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.UserEntity;

import java.util.Map;

/**
 * 党员信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-25 15:00:36
 */
public interface UserService extends IService<UserEntity> {

    LayuiPage queryPage(Map<String, Object> params);
}

