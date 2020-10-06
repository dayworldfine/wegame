package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：GameOverUserBoardDto
 * @Description:
 * @Author：13738700108
 * @Data 2020/10/7 0:19
 * @Version: v1.0
 **/
@Data
public class GameOverUserDto {

    private String userId;
    private String nickName;
    private String isWin;
    private String integral;
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
