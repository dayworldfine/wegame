package com.wegame.tools.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName：ValidateUtil
 * @Description: 校验工具类
 * @Author：13738700108
 * @Data 2020/9/10 21:53
 * @Version: v1.0
 **/
public class ValidateUtil {
    public ValidateUtil(){
    }

    public static boolean isCountEmpty(Integer integer) {
        return  integer == null || 0==integer;
    }

    public static boolean isNotCountEmpty(Integer integer) {
        return  !isCountEmpty(integer);
    }

    public static boolean isCountEmpty(Long l) {
        return  l == null || 0==l;
    }

    public static boolean isNotCountEmpty(Long l) {
        return  !isCountEmpty(l);
    }

    public static boolean isEmpty(String str) {
        return  str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return  !isEmpty(str);
    }

    public static boolean isEmpty(Integer integer) {
        return  integer == null ;
    }

    public static boolean isNotEmpty(Integer integer) {
        return  !isEmpty(integer);
    }
    public static boolean isEmpty(Long l) {
        return  l == null ;
    }

    public static boolean isNotEmpty(Long l) {
        return  !isEmpty(l);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }



}
