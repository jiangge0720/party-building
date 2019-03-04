package io.renren.modules.dangjian.service.impl;

import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.modules.dangjian.Constant.GroupUserConst;
import io.renren.modules.dangjian.dao.GroupUserDao;
import io.renren.modules.dangjian.dao.UserDao;
import io.renren.modules.dangjian.entity.GroupUserEntity;
import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.service.GroupUserService;
import io.renren.modules.dangjian.utils.DataSecurityUtil;
import io.renren.modules.dangjian.vo.GroupUserVo;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.GroupDao;
import io.renren.modules.dangjian.entity.GroupEntity;
import io.renren.modules.dangjian.service.GroupService;


@Service("groupService")
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupEntity> implements GroupService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupUserDao groupUserDao;

    @Autowired
    private GroupUserService groupUserService;

    @Override
    @DataFilter(userId = "created_by")
    public LayuiPage queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        String deptId = (String) params.get("deptId");
        if (Objects.equals(deptId, "0")) {
            deptId = null;
        }
        Page<GroupEntity> page = this.selectPage(
                new Query<GroupEntity>(params).getPage(),
                new EntityWrapper<GroupEntity>()
                  .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
                  .like(StringUtils.isNotBlank(name),"name", name)
                  .eq(StringUtils.isNotBlank(deptId), "dept_id", deptId)
        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    @Override
    public boolean insert(GroupEntity entity) {
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);
        entity.setDate(new Date());
        return super.insert(entity);
    }

    @Override
    public boolean updateById(GroupEntity entity) {
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);

        return super.updateById(entity);
    }

    @Override
    public void deleteGroup(Long[] ids) {
        // 从tb_group表中删除这些兴趣小组
        this.deleteBatchIds(Arrays.asList(ids));
        // 从tb_group_user表中删除这些小组的成员关系
        groupUserDao.delete(
          new EntityWrapper<GroupUserEntity>()
            .in("group_id", ids)
        );
    }

    //======================== 兴趣小组成员管理 ===========================
    /**
     * 列表查询，兴趣小组成员（已审核通过）
     */
    @Override
    public LayuiPage queryGroupUser(Map<String, Object> params) {
        params.put("state", GroupUserConst.STATE_APPROVED);
        List<GroupEntity> groupsOfUser = null;
        List<Long> groupIdsOfUser = null;
        Long deptId = null;

        SysUserEntity currUser = ShiroUtils.getUserEntity();
        if (!Objects.equals(currUser.getUsername(), "admin")) {
            deptId = currUser.getDeptId();
            groupsOfUser = this.selectList(new EntityWrapper<GroupEntity>().eq("dept_id", deptId));
            groupIdsOfUser = new ArrayList<>();
            for (GroupEntity group : groupsOfUser) {
                groupIdsOfUser.add(group.getId());
            }
        }
        Page<GroupUserVo> page = new Query<GroupUserVo>(params).getPage();
        List<GroupUserVo> result = userDao.queryGroupUser(page, params);

        if (groupIdsOfUser != null) {
            ListIterator<GroupUserVo> iterator = result.listIterator();
            while (iterator.hasNext()) {
                GroupUserVo user = iterator.next();
                if (!groupIdsOfUser.contains(user.getGroupId())) {
                    iterator.remove();
                }
            }
        }
        page.setRecords(result);

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    /**
     * 列表查询，兴趣小组成员（待审核）
     */
    @Override
    public LayuiPage queryGroupUserToVerify(Map<String, Object> params) {
        params.put("state", GroupUserConst.STATE_TO_VERIFY);
        List<GroupEntity> groupsOfUser = null;
        List<Long> groupIdsOfUser = null;
        Long deptId = null;

        SysUserEntity currUser = ShiroUtils.getUserEntity();
        if (!Objects.equals(currUser.getUsername(), "admin")) {
            deptId = currUser.getDeptId();
            groupsOfUser = this.selectList(new EntityWrapper<GroupEntity>().eq("dept_id", deptId));
            groupIdsOfUser = new ArrayList<>();
            for (GroupEntity group : groupsOfUser) {
                groupIdsOfUser.add(group.getId());
            }
        }
        Page<GroupUserVo> page = new Query<GroupUserVo>(params).getPage();
        List<GroupUserVo> result = userDao.queryGroupUser(page, params);

        if (groupsOfUser != null) {
            ListIterator<GroupUserVo> iterator = result.listIterator();
            while (iterator.hasNext()) {
                GroupUserVo user = iterator.next();
                if (!groupIdsOfUser.contains(user.getGroupId())) {
                    iterator.remove();
                }
            }
        }
        page.setRecords(result);

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    /**
     * 删除小组中的成员
     */
    @Override
    public Integer deleteGroupUser(Map<String, Object> params) {
        List<Integer> userIds = (List<Integer>) params.get("userIds");
        Integer groupId = (Integer) params.get("groupId");
        return groupUserDao.delete(
          new EntityWrapper<GroupUserEntity>()
            .in("user_id", userIds)
            .eq("group_id", groupId)
        );
    }

    /**
     * 审批通过加入小组成员
     */
    @Override
    public void approveGroupUserApply(Long[] ids) {
//    public void approveGroupUserApply(Map<String, Object> params) {
//        params.put("newState", GroupUserConst.STATE_APPROVED);
//        groupUserDao.handleGroupUserApply(params);
        List<GroupUserEntity> groupUserEntities = new ArrayList<>();
        for (Long id : ids) {
            GroupUserEntity groupUserEntity = new GroupUserEntity();
            groupUserEntity.setId(id);
            groupUserEntity.setState(GroupUserConst.STATE_APPROVED);
            groupUserEntities.add(groupUserEntity);
        }
        groupUserService.updateBatchById(groupUserEntities);
    }

    /**
     * 删除待审批成员
     */
    @Override
    public void denyGroupUserApply(Long[] ids) {
        List<Long> idList = Arrays.asList(ids);
        groupUserService.deleteBatchIds(idList);
    }
    /*public void denyGroupUserApply(Map<String, Object> params) {
        List<Integer> userIds = (List<Integer>) params.get("userIds");
        Integer groupId = (Integer) params.get("groupId");
        groupUserDao.delete(
          new EntityWrapper<GroupUserEntity>()
            .eq("group_id", groupId)
            .eq("state", GroupUserConst.STATE_TO_VERIFY)
            .in("user_id", userIds)
        );
        // 然后要通知申请人？？？
    }*/
}
