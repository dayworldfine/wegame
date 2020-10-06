package com.wegame.dto;

import lombok.Data;

/**
 * @ClassName：GameOverStatisticsDto
 * @Description: 游戏结束统计
 * @Author：13738700108
 * @Data 2020/10/7 1:59
 * @Version: v1.0
 **/
@Data
public class GameOverStatisticsDto {

    private String userId;
    private String isWin;
    private String integral;
}
