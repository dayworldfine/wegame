package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：SeatUserListDto
 * @Description:
 * @Author：13738700108
 * @Data 2020/10/5 14:28
 * @Version: v1.0
 **/
@Data
public class SeatUserListDto {

    private  Integer userId;

    private String userImg;

    private String userNickName;

    private Integer seatId;

    private Long integral;

    private Integer seatStatus;
}
