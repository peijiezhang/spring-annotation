package com.zcm.service.impl;

import com.zcm.dao.UserLoginDao;
import com.zcm.mybatis.data.User;
import com.zcm.service.UserLoginService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by zhangpeijie on 2018/11/9.
 */
// 相当于 <bean id="userLoginServiceImpl" class="com.zcm.service.impl.UserLoginServiceImpl">
// beanId 是不是 当前类名称第一个字母小写的id :userLoginServiceImpl
// 虽然可以 @Service(value = "userLoginService") 但是一般都不会这样
@Service
public class UserLoginServiceImpl implements UserLoginService,InitializingBean {

    /**
     * @Autowired如何工作
     * 首先去 执行 Object result = applicationContext.getBean("userLoginDao")
     * if (result == null){
     *     UserLoginDao userLoginDao = applicationContext.getBean(UserLoginDao.class);
     *     //但是上面的方式 如果当前的spring容器有多个 UserLoginDao对象，就会报错。
     *     那么spring为什么不用 getBeans（） 原因是：getBeans返回的多个对象也不知道用哪个
     *     所以还不如用上面哪个getBean(UserLoginDao.class)
     * }
     *
     * 假设当前的spring容器中有2个UserLoginDao,一个beanID 叫做 userLoginDao
     * 另一个叫做 userLoginDao2
     * 如果使用 @Autowired 不会报错。但是如果我想要用 userLoginDao2对应的bean
     * 可以使用 @Resource(name = "userLoginDao2")
     * 所以我们说 @Autowired 优先byName 再byType,都不行就报错
     * 一般能用 @Autowired 解决的事情就不要 @Resource 也不要用@Qualifier
     * 当 @Autowired 不能解决问题，使用@Resource 和@Qualifier
     *
     * 建议使用@Resource 指定当前bean对象的id 比如@Resource(name = "userLoginDao2")
     *
     */
    @Autowired
    //@Resource(name = "userLoginDao2")
    //@Qualifier
    UserLoginDao userLoginDao;

    public UserLoginServiceImpl(){
        System.out.println(" constructor was called");
    }

    /*public UserLoginServiceImpl( @Qualifier(value = "userLoginDao")UserLoginDao userLoginDao){
        System.out.println(" constructor was called");
        this.userLoginDao = userLoginDao;
    }*/

    @Override
    public boolean login(String userName, String password) {
       return userLoginDao.login( userName , password);
    }

    @Transactional
    @Override
    public void addUser(User user){

        userLoginDao.insert(user);

        //

        anotherTransaction( user);


    }

    @Transactional
    public void anotherTransaction(User user){



        // TODO op db


    }

    /**
     *
     */
    @PostConstruct
    public void init(){
        System.out.println(" 我要开始启动了");
    }

    /**
     * 当spring给我们创建当前对象后需要做什么
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I have been created by spring");
    }

    public UserLoginDao getUserLoginDao() {
        return userLoginDao;
    }

    public void setUserLoginDao(UserLoginDao userLoginDao) {
        this.userLoginDao = userLoginDao;
    }
}
