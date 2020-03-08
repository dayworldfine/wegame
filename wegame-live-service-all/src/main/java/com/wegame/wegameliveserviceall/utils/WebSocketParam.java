package com.wegame.wegameliveserviceall.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @ClassName：JsonObject
 * @Description: websocket返回类型
 * @Author：13738700108
 * @Data 2020/2/28 23:17
 * @Version: v1.0
 **/
public class WebSocketParam {

    /**
     * 房间信息
     * @param type
     * @param userList
     * @return
     */
    public static JSONObject room(String type,
                                  List<JSONObject> userList
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
     * @param money
     * @return
     */
    public static JSONObject userInToRoom(String type,
                                         String userId,
                                         String userImg,
                                         String userNickName,
                                         String money){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("userImg",userImg);
        obj.put("userNickName",userNickName);
        obj.put("money",money);
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
     *  用户坐下
     * @param type
     * @param userId
     * @param seat
     * @return
     */
    public static JSONObject userSitDown(String type,
                                  String userId,
                                  String seat ){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
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
     *  用户准备
     * @param type
     * @param userId
     * @param seat
     * @return
     */
    public  static JSONObject userPrepare(String type,
                                  String userId,
                                  String seat ){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        return obj;
    }

    /**
     * 用户看牌
     * @param type
     * @param userId
     * @param seat
     * @param board
     * @return
     */
    public static JSONObject userSeeCard(String type,
                                  String userId,
                                  String seat,
                                  String[] board){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        obj.put("board",board);
        return obj;
    }

    /**
     * 用户跟注
     * @param type
     * @param userId
     * @param seat
     * @param money
     * @return
     */
    public static JSONObject userSeeCard(String type,
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
     * 用户加注
     * @param type
     * @param userId
     * @param seat
     * @param money
     * @return
     */
    public static JSONObject userAddChip(String type,
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
     * @param seat
     * @return
     */
    public static JSONObject userDisCard(String type,
                                   String userId,
                                   String seat){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userId",userId);
        obj.put("seat",seat);
        return obj;
    }

    /**
     * 游戏开始
     * @param type
     * @param boardList
     * @return
     */
    public static JSONObject gameStart(String type,
                                JSONObject[] boardList){
        JSONObject obj = new JSONObject();
        obj.put("type",type);
        obj.put("userList",boardList);
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
     * @param serial
     * @return
     */
    public static String serial(String serial){
        String roomSerial ="";
        switch (serial){
            case "1":
                roomSerial = "one";
                break;
            case "2":
                roomSerial = "two";
                break;
            default:
                break;
        }
        return roomSerial;
    }
}
