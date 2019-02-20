package com.zcm.dao;

import com.zcm.mybatis.data.User;

/**
 * Created by zhangpeijie on 2018/11/9.
 */
public interface UserLoginDao {

    public boolean login(String userName, String password);

    void insert(User user);
}
