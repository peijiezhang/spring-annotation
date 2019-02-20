package com.zcm.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
public class DbcpSpringTest {

    @Test
    public void testSpringDbcp(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring-service.xml");



        BasicDataSource basicDataSource = (BasicDataSource)applicationContext.getBean("datasource");

        // 不能同时有多少个 BasicDataSource 类型的对象，如果有多个，就会报错
        // 如果真的想拿出多个,用 getBeansOfType
        BasicDataSource basicDataSource2 = applicationContext.getBean(BasicDataSource.class );

        // 前面就是 当前bean对象的id，后面的bean对象的实例
        Map<String,BasicDataSource> beanMap = applicationContext.getBeansOfType(BasicDataSource.class );

        System.out.println("beanMap ===" + beanMap );
        try {

            Connection connection = basicDataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");

            ResultSet resultSet = preparedStatement.executeQuery();

            while ( resultSet.next() ){


                System.out.print(resultSet.getString(1) + "\t");
                System.out.print(resultSet.getString(2) + "\t");
                System.out.print(resultSet.getString(3) + "\t");

                System.out.println("");

            }
            /**
             * 虽然方法是close,但是实际上是没有关闭的，而是换给了 dataSource
             */
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
