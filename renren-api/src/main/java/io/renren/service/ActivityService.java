package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1617:43
 */
public interface ActivityService extends IService<Activity> {

    List<Activity> selectActivity(String type);

    Integer count();
}
