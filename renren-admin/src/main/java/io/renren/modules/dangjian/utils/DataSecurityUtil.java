package io.renren.modules.dangjian.utils;

import io.renren.common.exception.RRException;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;

import java.lang.reflect.Field;

public class DataSecurityUtil {

  /**
   * 对于目标数据库的新增、修改，设置其dept_id和created_by字段为当前登陆用户的ID和所在部门
   */
  public static void setCurrUserInfo(Object object) {
    // 获取当前用户
    SysUserEntity currUser = ShiroUtils.getUserEntity();

    Class c = object.getClass();
    try {
      // 设置dept_id字段
      Field f = c.getDeclaredField("deptId");
//      f.setAccessible(true);
//      f.set(object, currUser.getDeptId());
      // 设置created_by字段
      f = c.getDeclaredField("createdBy");
      f.setAccessible(true);
      f.set(object, currUser.getUserId());
    } catch (Exception e) {
      throw new RRException(e.getMessage());
    }
  }
}
