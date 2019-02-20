package com.zcm.mybatis.mapper;

import com.zcm.mybatis.data.Category;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
public interface CategoryMapper {

    public Category selectById(String id);
}
