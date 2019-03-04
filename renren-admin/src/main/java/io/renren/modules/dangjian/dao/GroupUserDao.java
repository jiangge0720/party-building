package io.renren.modules.dangjian.dao;

import io.renren.modules.dangjian.entity.GroupUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

/**
 * 兴趣小组-党员关联表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-26 10:20:20
 */
public interface GroupUserDao extends BaseMapper<GroupUserEntity> {
  Integer handleGroupUserApply(Map<String, Object> params);
}
