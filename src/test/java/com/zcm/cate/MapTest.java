package com.zcm.cate;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangpeijie on 2018/11/15.
 */
public class MapTest {

    @Test
    public void testKey(){

        /**
         * key是哪个User，value代表有多钱
         */
        Map<User,Long> map = new HashMap<User, Long>();

        User user = new User("zcm",1L);

        map.put( user , 100L);

        System.out.println("user====" + map.get(user) );


        User user1 = new User("zcm",1L);
        // Map 怎么判断一个 K是同样的key
        System.out.println("user1====" + map.get(user1) );

        //map是通过key的hashcode和 equal方法来判断是不是一样的
        // 当前仅当 hashcode 和equal都相等才是同一个对象
        // 并不是通过地址来决定是不是一个对象
        System.out.println( user.hashCode() +"==" + user1.hashCode() );
        System.out.println( user.equals( user1 ));



        String name = new String("zcm");
        String name1 = new String("zcm");

        System.out.println( name == name1);

        System.out.println("===" + name.equals( name1 ));
        System.out.println( "====" + (name.hashCode() == name1.hashCode() ));


        System.out.println("==========================================");

        Map<String,Long> map1 = new HashMap<String, Long>();

        map1.put(new String("zcm"),100L);

        System.out.println("====" + map1.get("zcm"));

    }


    static class User{

        private String name;
        private Long age;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != null ? !age.equals(user.age) : user.age != null) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (age != null ? age.hashCode() : 0);
            return result;
        }

        public User(String name, Long age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }
    }
}


