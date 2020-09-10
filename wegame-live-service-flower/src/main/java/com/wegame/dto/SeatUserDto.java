package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：SeatUserDto
 * @Description: 桌子用户
 * @Author：13738700108
 * @Data 2020/9/10 21:32
 * @Version: v1.0
 **/
@Data
public class SeatUserDto {
    /**
     * 座位id
     */
    private Long id;
    /**
     * 座位状态
     */
    private Integer seatStatus;
    /**
     * 用户id
     */
    private Long userId;
}
