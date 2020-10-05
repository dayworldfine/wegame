package com.wegame.test;

import com.google.common.collect.Lists;
import com.wegame.dto.userCompareBoardDto;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName：CompareTest
 * @Description:
 * @Author：13738700108
 * @Data 2020/10/5 16:35
 * @Version: v1.0
 **/
public class CompareTest {

    public static void main(String[] args) {
        userCompareBoardDto userCompareBoardDtoOne = new userCompareBoardDto();
        userCompareBoardDtoOne.setUserId("1");
        userCompareBoardDtoOne.setBoardSize("10");

        userCompareBoardDto userCompareBoardDtoTwo = new userCompareBoardDto();
        userCompareBoardDtoTwo.setUserId("2");
        userCompareBoardDtoTwo.setBoardSize("20");
        List<userCompareBoardDto> userCompareBoardDtoList = Lists.newArrayList();
        userCompareBoardDtoList.add(userCompareBoardDtoTwo);
        userCompareBoardDtoList.add(userCompareBoardDtoOne);

        List<userCompareBoardDto> collect = userCompareBoardDtoList.stream()
                .sorted((o1, o2) -> {
                    int i = Long.valueOf(o1.getBoardSize()).compareTo(Long.valueOf(o2.getBoardSize()));
                    return i;
                }).collect(Collectors.toList());
        System.out.println(collect.toString());

        List<userCompareBoardDto> collect1 = userCompareBoardDtoList.stream()
                .sorted(Comparator.comparing(userCompareBoardDto::getBoardSize)).collect(Collectors.toList());
        System.out.println(collect1.toString());

    }


}
