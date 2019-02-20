package com.zcm.service;

import com.zcm.dao.UserLoginDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by zhangpeijie on 2018/11/9.
 */
public class LoginServiceSpringTest {



    @Test
    public void testLogin(){

        // 我们目前是用xml来启动的spring容器,所以 ApplicationContext 的实现类是 ClassPathXmlApplicationContext
        // 以后，还会有很多不同方式启动的spring容器，以后 ApplicationContext的实现类会有很多

        // classpath 代表当前的类资源路径  classpath*  代表整个工程下(包括当前项目引用了其他项目的jar里面的资源)
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring-service.xml");


        String applicationId = applicationContext.getId();

        System.out.println("applicationId===" + applicationId);

        //userLoginService = new UserLoginServiceImpl();
        UserLoginService userLoginService = (UserLoginService)applicationContext.getBean("userLoginServiceImpl");
        //  No qualifying bean of type 'com.zcm.service.UserLoginService' available: expected single matching bean but found 2: userLoginService,userLoginService2
        UserLoginService userLoginService1 = applicationContext.getBean(UserLoginService.class);

        Map<String,UserLoginService> map = applicationContext.getBeansOfType(UserLoginService.class);

        System.out.println("from spring ==" + userLoginService);
        System.out.println("from spring equal===" + (userLoginService == applicationContext.getBean("userLoginServiceImpl")) );
        System.out.println("from spring map ==" + map);

        System.out.println("loginResult===" + userLoginService.login("zcm","1234"));


        //  当前的spring容器中有几个我们创建的对象

        System.out.println("dao impl===" + applicationContext.getBeansOfType(UserLoginDao.class));
    }
}
