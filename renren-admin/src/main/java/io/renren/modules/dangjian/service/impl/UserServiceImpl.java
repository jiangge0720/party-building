package io.renren.modules.dangjian.service.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.renren.common.annotation.DataFilter;
import io.renren.common.exception.RRException;
import io.renren.common.utils.Constant;
import io.renren.modules.dangjian.dao.UserDao;
import io.renren.modules.dangjian.entity.UserEntity;
import io.renren.modules.dangjian.service.UserService;
import io.renren.modules.dangjian.utils.DataSecurityUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;



@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private ObjectMapper objectMapper;

    private JavaType javaType;

    @Override
    @DataFilter(userId = "created_by")
    public LayuiPage queryPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        String deptId = (String) params.get("deptId");
        if (Objects.equals(deptId, "0")) {
            deptId = null;
        }

        Page<UserEntity> page = this.selectPage(
                new Query<UserEntity>(params).getPage(),
                new EntityWrapper<UserEntity>()
                  .addFilterIfNeed(params.get(Constant.SQL_FILTER) != null, (String) params.get(Constant.SQL_FILTER))
                  .like(StringUtils.isNotBlank(name),"name", name)
                  .eq(StringUtils.isNotBlank(deptId), "dept_id", deptId)
        );


        try {
            for (UserEntity userEntity : page.getRecords()) {
                List<String> placeList = objectMapper.readValue(userEntity.getNativeplace(), getJavaType());
                StringBuilder sb = new StringBuilder();
                for (String s : placeList) {
                    sb.append(s);
                }
                userEntity.setNativeplace1(placeList);
                userEntity.setNativeplace(sb.toString());
            }
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
        return new LayuiPage(page.getRecords(), page.getTotal());
    }

    private JavaType getJavaType() {
        if (this.javaType == null) {
            this.javaType = getCollectionType(ArrayList.class, String.class);
        }
        return this.javaType;
    }

    private JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    @Override
    public UserEntity selectById(Serializable id) {
        UserEntity userEntity = super.selectById(id);

        try {
            List<String> placeList = objectMapper.readValue(userEntity.getNativeplace(), getJavaType());
            userEntity.setNativeplace1(placeList);
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
        return userEntity;
    }

    @Override
    public boolean insert(UserEntity entity) {
        if (StringUtils.isNotBlank(entity.getPassword())) {
            entity.setPassword(DigestUtils.sha256Hex(entity.getPassword()));
        }
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);
        // 将地址信息（JSON数组）序列化
        try {
            entity.setNativeplace(objectMapper.writeValueAsString(entity.getNativeplace1()));
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
        return super.insert(entity);
    }


    @Override
    public boolean updateById(UserEntity entity) {
        if (StringUtils.isNotBlank(entity.getPassword())) {
            entity.setPassword(DigestUtils.sha256Hex(entity.getPassword()));
        }
        // 添加dept_id和created_by字段
        DataSecurityUtil.setCurrUserInfo(entity);
        // 将地址信息（JSON数组）序列化
        try {
            entity.setNativeplace(objectMapper.writeValueAsString(entity.getNativeplace1()));
        } catch (Exception e) {
            throw new RRException(e.getMessage());
        }
        return super.updateById(entity);
    }
}
