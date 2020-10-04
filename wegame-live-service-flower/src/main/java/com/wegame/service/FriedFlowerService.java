package com.wegame.service;


import com.alibaba.fastjson.JSONObject;
import com.wegame.config.BaseService;
import com.wegame.dto.SeatUserDto;
import com.wegame.model.Room;
import com.wegame.model.User;
import com.wegame.vo.Message;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName：WebSocketService
 * @Description:
 * @Author：13738700108
 * @Data 2020/2/12 14:39
 * @Version: v1.0
 **/
public interface FriedFlowerService  extends  BaseService{

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
    Room findRoomMessageByRoomSerial(Integer roomSerial);

//    /**
//     * 根据房间查询所有座位
//     * @param room
//     * @return
//     */
//    List<Seat> findSeatsByRoom(Room room);


    /**
     * 发送用户进入房间
     * @param message
     */
    void sendUserInToRoomMessage(Map<String, Object> message);

    /**
     * 发送房间信息
     * @param room
     */
    void sendRoomMessage(Room room, Map<String, Object> message);


    /**
     * 查询这个位置是否有人（0 没人  1有人）
     * @param roomSerial
     * @param seatSerial
     * @return
     */
    int selSeatHavePeople(int roomSerial, int seatSerial);

    /**
     * 操作坐下
     * @param userCode
     * @param seatSerial
     * @param roomSerial
     * @return
     */
    int SaveUserSitDown(int userCode, int seatSerial, int roomSerial);

    /**
     * 发送有人坐下
     * @param type
     * @param roomSerial
     * @param userCode
     * @param seatSerial
     */
    void sendUserSitDown(int type, int roomSerial, int userCode, int seatSerial, String userImg, String userNickName, int integral);

    /**
     * 用户准备
     * @param roomSerial
     * @param userCode
     * @param seatSerial
     * @return
     */
    int saveUserSetOut(int roomSerial, int userCode, int seatSerial);

    /**
     * 用户发送准备
     * @param type
     * @param roomSerial
     * @param seatSerial
     */
    void sendUserSetOut(int type, int roomSerial, int seatSerial);

    /**
     * 查询房间人数和已准备人数
     * @param roomSerial
     * @return
     */
    List<SeatUserDto> selGmaeStartCondition(int roomSerial);


    /**
     * 发牌游戏开始
     * @param roomSerial
     */
    void sendAndSaveGmaeStart(int roomSerial, List<SeatUserDto> countMap,List<SeatUserDto> SeatUserDtoCountSetOut);

    /**
     * 改变用户看牌状态
     * @param userId
     * @param gamblingId
     * @param type
     * @param roomId
     */
    int updateUserSeeCard(long userId, long gamblingId, int type, long roomId,int round,long seatId , int sort);

    /*发送用户看牌*/
    void sendUserSeeCard(int type, long roomId, long gamblingId, long userId,long seatId);

    /**
     * 用户跟注
     * @param userId
     * @param gamblingId
     * @param type
     * @param roomId
     * @param round
     * @param seatId
     * @param integralFundus
     * @return
     */
    int addUserWithChip(long userId, long gamblingId, int type, long roomId, int round, long seatId, long integralFundus, int sort);

    /*发送用户跟注*/
    void sendAddUserWithChip(int type, long roomId, long gamblingId, long userId, long seatId, long integralFundus,int roundNum,long trueUserId);

    /**
     * 添加用户弃牌
     * @param type
     * @param roomId
     * @param seatId
     * @param gamblingId
     * @param round
     * @param sort
     * @return
     */
    int addUserDisCard(int type, long roomId, long seatId, long gamblingId, int round, int sort,long userId);

    /**
     * 判断需不需要改变轮次 需要则改 ,不需要不改 返回轮次round
     * @param gamblingId
     * @return
     */
    JSONObject changGeRound(long gamblingId);

    /*发送有人弃牌消息*/
    void sendUserDisCard(int type, long roomId, long seatId, long gamblingId, int roundNum,long userId,long trueUserId);
}
