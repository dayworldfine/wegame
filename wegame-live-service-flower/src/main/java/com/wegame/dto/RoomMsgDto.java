package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：RoomMsgDto
 * @Description:
 * @Author：13738700108
 * @Data 2020/9/16 21:21
 * @Version: v1.0
 **/
@Data
public class RoomMsgDto {
    private String roomId;
    private Integer gamblingStatus;
    private String integralFundus;
    private String integralSum;
    private String gamblingId;
    private Long round;
}
