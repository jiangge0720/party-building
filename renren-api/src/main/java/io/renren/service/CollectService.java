package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Collect;
import io.renren.utils.JiangPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Jiang-gege
 * 2018/7/2413:31
 */
public interface CollectService extends IService<Collect> {
    JiangPage queryPage(Map<String, Object> params);

    void insertCollect(Collect collect);

    int getCollectCount(int articleId);

    List selectMyCollect( String userId);

    void cancleCollect( int articleId);
}
