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
    int selSeatHavePeople(long roomSerial, long seatSerial);

    /**
     * 操作坐下
     * @param userId
     * @param seatId
     * @param roomId
     * @return
     */
    int SaveUserSitDown(long userId, long seatId, long roomId);

    /**
     * 发送有人坐下
     * @param type
     * @param roomId
     * @param userId
     * @param seatId
     */
    void sendUserSitDown(int type, long roomId, long userId, long seatId);

    /**
     * 用户准备
     * @param roomId
     * @param userId
     * @param seatId
     * @return
     */
    int saveUserSetOut(long roomId, long userId, long seatId);

    /**
     * 用户发送准备
     * @param type
     * @param roomId
     * @param seatId
     */
    void sendUserSetOut(int type, long roomId, long seatId);

    /**
     * 查询房间人数和已准备人数
     * @param roomId
     * @return
     */
    List<SeatUserDto> selGmaeStartCondition(long roomId);


    /**
     * 发牌游戏开始
     * @param roomId
     */
    void sendAndSaveGmaeStart(long roomId, List<SeatUserDto> countMap,List<SeatUserDto> SeatUserDtoCountSetOut);

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

    /**
     * 检查是否游戏结束
     * @param gamblingId
     */
    void examineGameOver(long gamblingId,long roomId);

    /**
     * 用户比牌
     * @param userId
     * @param gamblingId
     * @param type
     * @param roomId
     * @param round
     * @param seatId
     * @param sort
     * @param beUserId
     * @return
     */
    JSONObject compareThanCard(long userId, long gamblingId, int type, long roomId, int round, long seatId, int sort, long beUserId,long integralFundus);

    /*发送比牌消息*/
    void sendUserThanCard(int type, long roomId, long gamblingId, long userId, long seatId, Integer round, Long trueUserId,String loseUserId,long integralFundus,long beUserId);

    /**
     * 清理所有桌子的用户
     */
    void updateSeatUser();
}
