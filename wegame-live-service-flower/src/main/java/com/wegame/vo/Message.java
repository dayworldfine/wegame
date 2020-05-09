package com.wegame.vo;

import lombok.Data;

/**
 * @ClassName：Message
 * @Description: 接受消息
 * @Author：13738700108
 * @Data 2020/2/21 22:19
 * @Version: v1.0
 **/
@Data
public class Message {

    /**
     * 类型
     */
    private String type;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户头像
     */
    private String userImg;

    /**
     * 钱
     */
    private String money;

    /**
     * 房间序号
     */
    private String roomSerial;

    /**
     * 昵称
     */
    private String userNickName;

    private String asdas;

    public Message() {
    }

    public Message(String type, String userId, String userImg, String money, String roomSerial, String userNickName) {
        this.type = type;
        this.userId = userId;
        this.userImg = userImg;
        this.money = money;
        this.roomSerial = roomSerial;
        this.userNickName = userNickName;
    }
}
