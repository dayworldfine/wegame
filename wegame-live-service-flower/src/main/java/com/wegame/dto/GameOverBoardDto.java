package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：GameBoardDto
 * @Description:
 * @Author：13738700108
 * @Data 2020/10/7 1:51
 * @Version: v1.0
 **/
@Data
public class GameOverBoardDto {
    private String userId;
    private String boardSize;
    private String boardType;
    private String isSpecial;
    private String isA32;
    private String firstBoardColor;
    private String firstBoardNumber;
    private String secondBoardColor;
    private String secondBoardNumber;
    private String thirdlyBoardColor;
    private String thirdlyBoardNumber;
}
