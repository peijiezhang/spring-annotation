package com.zcm.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by zhangpeijie on 2018/11/14.
 */
public class DbcpTest {


    @Test
    public void testJDBCConnection(){


        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/web21";
        String username = "root";
        String password = "123";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            // 每次都new 了一个连接，这句话十分消耗系统资源
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {

            Connection connection = conn;
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

    @Test
    public void testDbcp2(){


        BasicDataSource basicDataSource = new BasicDataSource();

        // 必须的属性
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/web21?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowMultiQueries=true");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123");

        //基本的属性

        basicDataSource.setMaxTotal(100);
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxIdle(20);


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
