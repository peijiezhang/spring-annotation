package com.zcm.service;

import com.zcm.mybatis.data.User;

/**
 * Created by zhangpeijie on 2018/11/9.
 */
public interface UserLoginService {

    public boolean login(String userName, String password);

    public void addUser(User user);
}
