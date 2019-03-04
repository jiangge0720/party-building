package io.renren.modules.dangjian.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.common.utils.LayuiPage;
import io.renren.modules.dangjian.entity.GroupEntity;

import java.util.Map;

/**
 * 兴趣小组
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:14:05
 */
public interface GroupService extends IService<GroupEntity> {

    LayuiPage queryPage(Map<String, Object> params);
    void deleteGroup(Long[] ids);

    LayuiPage queryGroupUser(Map<String, Object> params);
    LayuiPage queryGroupUserToVerify(Map<String, Object> params);
    Integer deleteGroupUser(Map<String, Object> params);
    void approveGroupUserApply(Long[] ids);
    void denyGroupUserApply(Long[] ids);

}

