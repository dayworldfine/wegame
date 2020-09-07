package com.wegame.entity;

import lombok.Data;

@Data
public class SeatUserEntity {

    private  Integer userId;

    private String userImg;

    private String userNickName;

    private Integer seatId;

    private Long integral;

    private Integer seatStatus;

    private Integer boardA;

    private Integer boardB;

    private Integer boardC;
}
