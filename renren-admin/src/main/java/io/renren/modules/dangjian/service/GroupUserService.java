package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.GroupUserEntity;

import java.util.Map;

/**
 * 兴趣小组-党员关联表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:20:20
 */
public interface GroupUserService extends IService<GroupUserEntity> {

    LayuiPage queryPage(Map<String, Object> params);

}

