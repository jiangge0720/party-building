/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.sys.dao.SysUserDao;
import io.renren.modules.sys.entity.SysDeptEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.service.ShiroService;
import io.renren.modules.sys.service.SysDeptService;
import io.renren.modules.sys.service.SysUserRoleService;
import io.renren.modules.sys.service.SysUserService;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:46:09
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysDeptService sysDeptService;
	@Autowired
	private ShiroService shiroService;

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return baseMapper.queryAllMenuId(userId);
	}

	@Override
	@DataFilter(subDept = true, user = false)
	public LayuiPage queryPage(Map<String, Object> params) {
		String username = (String)params.get("username");

		Page<SysUserEntity> page = this.selectPage(
			new Query<SysUserEntity>(params).getPage(),
			new EntityWrapper<SysUserEntity>()
				.like(StringUtils.isNotBlank(username),"username", username)
				.addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
		);

		for(SysUserEntity sysUserEntity : page.getRecords()){
			SysDeptEntity sysDeptEntity = sysDeptService.selectById(sysUserEntity.getDeptId());
			sysUserEntity.setDeptName(sysDeptEntity.getName());
		}

		return new LayuiPage(page.getRecords(), page.getTotal());
	}

	@Override
	public SysUserEntity queryByUserName(String username) {
		return baseMapper.queryByUserName(username);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(SysUserEntity user) {
		user.setCreateTime(new Date());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		user.setSalt(salt);
		user.setPassword(new Sha256Hash(user.getPassword(), salt).toHex());
		this.insert(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SysUserEntity user) {
		if(StringUtils.isBlank(user.getPassword())){
			user.setPassword(null);
		}else{
			user.setPassword(new Sha256Hash(user.getPassword(), user.getSalt()).toHex());
		}
		this.updateById(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}



	@Override
	public boolean updatePassword(Long userId, String password, String newPassword) {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setPassword(newPassword);
        return this.update(userEntity,
                new EntityWrapper<SysUserEntity>().eq("user_id", userId).eq("password", password));
    }

	@Override
	public R queryUserInfoForIviewAdmin() {
		SysUserEntity currUser = (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
		/*List<String> currUserRoles;
		if (currUser.getUserId() == 1) {
			currUserRoles = Arrays.asList("super_admin");
		} else {
			currUserRoles = baseMapper.queryUserRole(currUser.getUserId());
		}*/
		Set<String> permissions = shiroService.getUserPermissions(ShiroUtils.getUserId());

		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("username", currUser.getUsername());
		userInfo.put("userId", currUser.getUserId());
		userInfo.put("access", permissions);
		userInfo.put("avator", "");
		return R.ok().put("user", userInfo);
	}
}
