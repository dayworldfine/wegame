package com.wegame.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @ClassName：RoomMsgDto
 * @Description: 房间信息Dto
 * @Author：13738700108
 * @Data 2020/9/16 20:43
 * @Version: v1.0
 **/
@Data
public class RoomMsgVo {
    private String roomId;
    private Integer gamblingStatus;
    private String integralFundus;
    private String integralSum;
    private String gamblingId;
    private Long round;
    private List<RoomChildMsgVo> roomChildMsgVoList = Lists.newArrayList();
}
