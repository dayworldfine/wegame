package com.wegame.vo;

import lombok.Data;

/**
 * @ClassName：RoomChildMsgVo
 * @Description: 房间子类信息
 * @Author：13738700108
 * @Data 2020/9/16 20:58
 * @Version: v1.0
 **/
@Data
public class RoomChildMsgVo {
    private String userId;
    private String headPortrait;
    private String integral;
    private String nickName;

    private String seatId;
    private Integer isBanker;
    private Integer isUser;
    private Integer seeCardStatus;
    private Integer gameStatus;

    private Integer boardSize;
    private Integer boardType;
    private Integer isSpecial;
    private Integer isA32;
    private Integer firstBoardColor;
    private Integer firstBoardNumber;
    private Integer secondBoardColor;
    private Integer secondBoardNumber;
    private Integer thirdlyBoardColor;
    private Integer thirdlyBoardNumber;
}
