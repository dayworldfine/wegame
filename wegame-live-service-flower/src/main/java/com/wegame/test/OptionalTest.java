package com.wegame.test;

import java.util.Optional;

/**
 * @ClassName：OptionalTest
 * @Description:
 * @Author：13738700108
 * @Data 2020/9/10 21:40
 * @Version: v1.0
 **/
public class OptionalTest {

    public static void main(String[] args) {
        Integer num1 = 0;
        Integer num2 = null;
        String string1="1";
        String string2="";
        String string3=null;
        System.out.println("test1:"+Optional.ofNullable(num1));
        System.out.println("test2:"+Optional.ofNullable(num1).isPresent());
        System.out.println("test3:"+Optional.ofNullable(string1));
        System.out.println("test4:"+Optional.ofNullable(string1).isPresent());
        System.out.println("test5:"+Optional.ofNullable(string2));
        System.out.println("test6:"+Optional.ofNullable(string2).isPresent());
        System.out.println("test7:"+Optional.ofNullable(string3));
        System.out.println("test8:"+Optional.ofNullable(string3).isPresent());
    }
}
