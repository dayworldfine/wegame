package com.wegame.wegameliveserviceall.service;

import com.wegame.wegameliveserviceall.entity.Room;
import com.wegame.wegameliveserviceall.entity.Seat;
import com.wegame.wegameliveserviceall.vo.Message;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName：WebSocketService
 * @Description: 即时通讯
 * @Author：13738700108
 * @Data 2020/2/12 14:39
 * @Version: v1.0
 **/
public interface WebSocketService {

    /**
    * @Author wbh
    * @Description 发送消息
    * @Date 16:20 2020/2/12
    * @Param
    * @return
    **/
    void sendMessage(Message message);

    /**
     * 根据房间序号查询房间信息
     * @param roomSerial
     * @return
     */
    Room findRoomMessageByRoomSerial(String roomSerial);

    /**
     * 根据房间查询所有座位
     * @param room
     * @return
     */
    List<Seat> findSeatsByRoom(Room room);


    /**
     * 发送用户进入房间
     * @param message
     */
    void sendUserInToRoomMessage(Map<String, String> message);

    /**
     * 发送房间信息
     * @param room
     */
    void sendRoomMessage(Room room, Map<String, String> message);
}
