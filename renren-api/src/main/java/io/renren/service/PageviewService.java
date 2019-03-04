package io.renren.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.Pageview;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1816:09
 */
public interface PageviewService extends IService<Pageview> {

    List<Pageview> selectIp (String ip);

    void insertPageview (Pageview pageview);

    Integer count ();

    List<Pageview> selectAll ();

    Integer topiccount();

}
