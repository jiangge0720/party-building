package io.renren.modules.dangjian.dao;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import io.renren.modules.dangjian.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.modules.dangjian.vo.GroupUserVo;

import java.util.List;
import java.util.Map;

/**
 * 党员信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-25 15:00:36
 */
public interface UserDao extends BaseMapper<UserEntity> {
  List<GroupUserVo> queryGroupUser(Pagination page, Map<String, Object> params);

}
