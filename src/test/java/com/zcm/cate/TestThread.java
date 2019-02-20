package com.zcm.cate;

/**
 * Created by zhangpeijie on 2018/11/15.
 */
public class TestThread {


    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("begin");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("end");
            }
        });

        thread.start();

        // thread.join方法会等在这里，直到这个线程执行完
        thread.join();

        System.out.println("继续走");

    }
}
