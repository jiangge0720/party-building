package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Like;

/**
 * @author Jiang-gege
 * 2018/9/1213:16
 */
public interface LikeService extends IService<Like> {

    void cancleLike( int topicId);
}
