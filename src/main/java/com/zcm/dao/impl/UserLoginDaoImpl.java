package com.zcm.dao.impl;

import com.zcm.dao.UserLoginDao;
import com.zcm.mybatis.data.User;
import com.zcm.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangpeijie on 2018/11/9.
 */
// 相当于  <bean id="userLoginDaoImpl" class="com.zcm.dao.impl.UserLoginDaoImpl"></bean>
@Service
public class UserLoginDaoImpl implements UserLoginDao {


    @Autowired
    UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {

        // 假设我们现在访问的是数据库
        if ( userName.equals("zcm") && password.equals("123")){
            return true;
        }
        return false;
    }

    @Override
    public void insert(User user) {

        userMapper.insert( user);
    }
}
