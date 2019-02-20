package com.zcm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-service.xml"})
public class SpringJunit {



    @Autowired
    UserLoginService userLoginService;


    @Test
    public void testLogin(){
        boolean res = userLoginService.login("zcm","123");


        System.out.println("==============="  + res);
    }



}
