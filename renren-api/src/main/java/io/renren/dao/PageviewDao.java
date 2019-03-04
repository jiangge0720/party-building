package io.renren.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.renren.entity.Pageview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Jiang-gege
 * 2018/9/1816:07
 */
@Mapper
public interface PageviewDao extends BaseMapper<Pageview>{

    List<Pageview> selectIp (String ip);

    void insertPageview (Pageview pageview);

    Integer count ();

    List<Pageview> selectAll ();

    Integer topiccount();

}
