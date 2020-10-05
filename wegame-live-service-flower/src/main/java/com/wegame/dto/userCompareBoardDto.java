package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：userCompareBoardDto
 * @Description:
 * @Author：13738700108
 * @Data 2020/10/5 16:08
 * @Version: v1.0
 **/
@Data
//public class userCompareBoardDto implements Comparable<userCompareBoardDto> {
public class userCompareBoardDto {
    private String userId;
    private String boardSize;

//    @Override
//    public int compareTo(userCompareBoardDto o) {
//        return Long.valueOf(this.boardSize).compareTo(Long.valueOf(o.getBoardSize()));
//    }
}
