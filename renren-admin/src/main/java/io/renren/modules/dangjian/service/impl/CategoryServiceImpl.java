package io.renren.modules.dangjian.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.LayuiPage;
import io.renren.common.utils.Query;

import io.renren.modules.dangjian.dao.CategoryDao;
import io.renren.modules.dangjian.entity.CategoryEntity;
import io.renren.modules.dangjian.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public LayuiPage queryPage(Map<String, Object> params) {
        Page<CategoryEntity> page = this.selectPage(
                new Query<CategoryEntity>(params).getPage(),
                new EntityWrapper<CategoryEntity>()
        );

        return new LayuiPage(page.getRecords(), page.getTotal());
    }

}
