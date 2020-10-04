package com.wegame.tools.flower;

import com.alibaba.fastjson.JSONObject;
import com.wegame.entity.SeatUserEntity;
import com.wegame.vo.RoomMsgVo;

import java.util.List;

/**
 * @ClassName：JsonObject
 * @Description: websocket返回类型
 * @Author：13738700108
 * @Data 2020/2/28 23:17
 * @Version: v1.0
 **/
public class FriedFlowerJsonObject {

    /**
     * 房间信息
     * @param type
     * @param userList
     * @return
     */
    public static JSONObject room(int type,
                                  List<SeatUserEntity> userList
                                 ){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userList",userList);
        return obj;
    }

    /**
     * 用户进入房间
     * @param type
     * @param userId
     * @param userImg
     * @param userNickName
     * @param integral
     * @return
     */
    public static JSONObject userInToRoom(int type,
                                         String userId,
                                         String userImg,
                                         String userNickName,
                                         int integral){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("userImg",userImg);
        obj.put("userNickName",userNickName);
        obj.put("integral",integral);
        return obj;
    }

    /**
     * 用户退出房间
     * @param type
     * @param userId
     * @return
     */
    public static JSONObject userOutRoom(String type,
                                   String userId){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        return obj;
    }

    /**
     * 用户坐下
     * @param type
     * @param userCode
     * @param seatSerial
     * @param userImg
     * @param userNickName
     * @param integral
     * @return
     */
    public static JSONObject userSitDown(int type,
                                         int userCode,
                                         int seatSerial,
                                         String userImg,
                                         String userNickName,
                                         int integral){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userCode",userCode);
        obj.put("seatSerial",seatSerial);
        obj.put("userImg",userImg);
        obj.put("userNickName",userNickName);
        obj.put("integral",integral);
        return obj;
    }

    /**
     *  用户站起来
     * @param type
     * @param userId
     * @param seat
     * @return
     */
    public static JSONObject userStandUp(String type,
                                  String userId,
                                  String seat ){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        return obj;
    }

    /**
     * 用户准备
     * @param type
     * @param seatSerial
     * @return
     */
    public  static JSONObject userSetOut(int type,
                                  int seatSerial ){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("seatId",seatSerial);
        return obj;
    }

    /**
     * 用户看牌
     * @param type
     * @param userId
     * @param seatId
     * @return
     */
    public static JSONObject userSeeCard(int type,
                                  String userId,
                                  String seatId){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seatId",seatId);
        return obj;
    }

    /**
     * 用户跟注
     * @param type
     * @param userId
     * @param seatId
     * @param integralFundus
     * @return
     */
    public static JSONObject userWithChip(int type,
                                  String userId,
                                  String seatId,
                                  String integralFundus,
                                  int roundNum,
                                      String  trueUserId){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seatId",seatId);
        obj.put("integralFundus",integralFundus);
        obj.put("round",roundNum);
        obj.put("trueUserId",trueUserId);
        return obj;
    }

    /**
     * 用户加注
     * @param type
     * @param userId
     * @param seat
     * @param money
     * @return
     */
    public static JSONObject userAddChip(int type,
                                  String userId,
                                  String seat,
                                  String money){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        obj.put("money",money);
        return obj;
    }

    /**
     * 用户比牌
     * @param type
     * @param userId
     * @param seat
     * @param beUserId
     * @param beSeat
     * @return
     */
    public static JSONObject userThanCard(String type,
                                  String userId,
                                  String seat,
                                  String beUserId,
                                  String beSeat){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        obj.put("beUserId",beUserId);
        obj.put("beSeat",beSeat);
        return obj;
    }

    /**
     * 用户弃牌
     * @param type
     * @param userId
     * @param seatId
     * @return
     */
    public static JSONObject userDisCard(int type,
                                   String userId,
                                   String seatId,
                                         int round,
                                         String trueUserId){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seatId",seatId);
        obj.put("round",round);
        obj.put("trueUserId",trueUserId);
        return obj;
    }

    /**
     * 游戏开始
     * @param type
     * @param roomMsgVo
     * @return
     */
    public static JSONObject gameStart(int type,
                                       RoomMsgVo roomMsgVo){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userList",roomMsgVo);
        return obj;
    }

    /**
     * 游戏结束
     * @param type
     * @param boardList
     * @return
     */
    public static JSONObject gameOver(String type,
                               JSONObject[] boardList){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userList",boardList);
        return obj;
    }

    /**
     * 根据房间序号返回订阅号后缀
     * @param roomId
     * @return
     */
    public static String serial(int roomId){
        String roomSerial ="";
        switch (roomId){
            case 1:
                roomSerial = "one";
                break;
            case 2:
                roomSerial = "two";
                break;
            case 3:
                roomSerial = "three";
                break;
            case 4:
                roomSerial = "four";
                break;
            case 5:
                roomSerial = "five";
                break;
            case 6:
                roomSerial = "six";
                break;
            case 7:
                roomSerial = "seven";
                break;
            default:
                break;
        }
        return roomSerial;
    }
}
