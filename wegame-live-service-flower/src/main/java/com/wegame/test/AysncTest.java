package com.wegame.test;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName：AysncTest
 * @Description: 异步测试类
 * @Author：13738700108
 * @Data 2020/9/16 19:51
 * @Version: v1.0
 **/
public class AysncTest {

    public static void main(String[] args) {

        String s = testReturn();
        System.out.println("线程到开始了"+s);
    }

    public static String testReturn(){
        ExecutorService cachePool = Executors.newCachedThreadPool();
        cachePool.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(10000l);
                System.out.println("线程到这里了");
            }
        });
        return "123";
    }
}
