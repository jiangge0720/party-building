package io.renren.modules.dangjian.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;
import io.renren.modules.dangjian.dao.DeptDao;
import io.renren.modules.dangjian.entity.DeptEntity;
import io.renren.modules.dangjian.service.DeptService;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service("deptService")
public class DeptServiceImpl extends ServiceImpl<DeptDao, DeptEntity> implements DeptService {
  @Override
  public LayuiPage queryPage(Map<String, Object> params) {
    String name = (String) params.get("name");
    Long deptId = null;

    SysUserEntity currUser = ShiroUtils.getUserEntity();
    if (!Objects.equals(currUser.getUsername(), "admin")) {
      deptId = currUser.getDeptId();
    }
    Page<DeptEntity> page = this.selectPage(
      new Query<DeptEntity>(params).getPage(),
      new EntityWrapper<DeptEntity>()
        .eq("parent_id", 1L)
        .eq(deptId != null, "dept_id", deptId)
        .like(StringUtils.isNotBlank(name), "name", name)
    );

    return new LayuiPage(page.getRecords(), page.getTotal());
  }
}
