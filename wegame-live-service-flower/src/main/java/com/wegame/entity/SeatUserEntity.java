package com.wegame.entity;

import lombok.Data;

@Data
public class SeatUserEntity {

    private  Integer userId;

    private String userImg;

    private String userNickName;

    private Integer seatSerial;

    private Long integral;

    private Integer boardA;

    private Integer boardB;

    private Integer boardC;
}
