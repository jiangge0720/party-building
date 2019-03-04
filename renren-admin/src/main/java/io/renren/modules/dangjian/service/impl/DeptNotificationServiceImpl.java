package io.renren.modules.dangjian.service.impl;

import io.renren.common.utils.Constant;
import io.renren.modules.dangjian.utils.DataSecurityUtil;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.DeptNotificationDao;
import io.renren.modules.dangjian.entity.DeptNotificationEntity;
import io.renren.modules.dangjian.service.DeptNotificationService;


@Service("deptNotificationService")
public class DeptNotificationServiceImpl extends ServiceImpl<DeptNotificationDao, DeptNotificationEntity> implements DeptNotificationService {

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        String title = (String) params.get("title");
        String deptId = (String) params.get("deptId");
        if (Objects.equals(deptId, "0")) {
            deptId = null;
        }

        SysUserEntity currUser = ShiroUtils.getUserEntity();
        if (!Objects.equals(currUser.getUsername(), "admin")) {
            deptId = currUser.getDeptId().toString();
        }
        Page<DeptNotificationEntity> page = this.selectPage(
                new Query<DeptNotificationEntity>(params).getPage(),
                new EntityWrapper<DeptNotificationEntity>()
                        .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
                        .like(StringUtils.isNotBlank(title),"title", title)
                        .eq(StringUtils.isNotBlank(deptId), "dept_id", deptId)
        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    @Override
    public boolean insert(DeptNotificationEntity entity) {
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);
        entity.setDate(new Date());
        return super.insert(entity);
    }

    @Override
    public boolean updateById(DeptNotificationEntity entity) {
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);

        return super.updateById(entity);
    }

}
