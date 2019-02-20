package com.zcm.mybatis.mapper.ext;

import com.zcm.mybatis.data.User;

import java.util.List;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
public interface UserMapperExt {


    public void batchInsert(List<User> usersList);
}
