package com.zcm.action;

import com.zcm.mybatis.data.User;
import com.zcm.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangpeijie on 2018/11/25.
 */
@Controller
@RequestMapping("/user")
public class LoginAction {


    @Autowired
    UserLoginService userLoginService;

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user){

        boolean ok = userLoginService.login( user.getUsername() , user.getPassword());

        String result = ok ? "success":"failed";

        return user;
    }
}
