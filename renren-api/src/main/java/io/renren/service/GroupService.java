package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Group;
import io.renren.utils.JiangPage;

import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2016:18
 */
public interface GroupService extends IService<Group>{
    JiangPage queryPage(Map<String, Object> params);

    void insertGroup(Group group);
}
