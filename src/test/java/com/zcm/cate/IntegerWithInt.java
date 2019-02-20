package com.zcm.cate;

import org.junit.Test;

/**
 * Created by zhangpeijie on 2018/11/15.
 */
public class IntegerWithInt {


    /**
     * int 永远有值
     *
     */
    @Test
    public void testIntegerWithInt(){


        int a = 0;

        System.out.println(a);

        // integer 是可以复制为 null，为什么
        // 因为 Integer 是一个类，任何类的实例都可以是null
        Integer integer = null ;

        System.out.println( integer);
    }


    @Test
    public void equal(){

        int a = 1;
        Integer integer = 1;

        // 返回 true
        // jvm中有一个叫做常量池的东西,-127~128都会在常量池中有一个备份
        // 这些值和 int 是没有什么区别的
        System.out.println( a == integer );

        System.out.println("==============================");

        Integer integer1 = new Integer(13);
        Integer integer2 = new Integer(13);
        System.out.println( integer1 == integer2);

        int b = 1234;
        Integer integerA = new Integer(1234);
        Integer integerB = new Integer(1234);

        System.out.println("==============================");

        System.out.println( b == integerA);
        System.out.println( b == integerB);
        // 因为地址不一样
        System.out.println( integerA == integerB);
    }

}
