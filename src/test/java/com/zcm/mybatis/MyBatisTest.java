package com.zcm.mybatis;

import com.zcm.mybatis.data.User;
import com.zcm.mybatis.data.UserExample;
import com.zcm.mybatis.mapper.UserMapper;
import com.zcm.mybatis.mapper.ext.UserMapperExt;
import com.zcm.service.UserLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class MyBatisTest {



    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperExt userMapperExt;


    @Test
    public void testInsert(){


        User user = new User();
        user.setUsername("zcm");
        user.setPassword("zcm");

        userMapper.insert(user);


    }

    @Test
    public void testBatchInsert(){

        List<User> listUser = new ArrayList<User>();

        for ( int i = 0 ;i < 3 ; i++ ){

            User user = new User();
            user.setUsername("zcm" + i);
            user.setPassword("zcm" + i);

            listUser.add( user);
        }

        userMapperExt.batchInsert(listUser);


    }

    @Test
    public void select(){

        UserExample userExample = new UserExample();

        userExample.createCriteria().andUsernameEqualTo("zcm");

        List<User> users = userMapper.selectByExample(userExample);

        System.out.println();

    }




}
