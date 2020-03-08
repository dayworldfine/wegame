package com.wegame.wegameliveserviceall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wegame.wegameliveserviceall.entity.Room;
import com.wegame.wegameliveserviceall.entity.Seat;
import com.wegame.wegameliveserviceall.service.WebSocketService;
import com.wegame.wegameliveserviceall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
//@RequestMapping("/websocket")
public class WebSocketController {

    @Autowired
    private WebSocketService ws;

//    @MessageMapping("/sendMessage")
////    public void sendMessage(String id,
////                            String userName,
////                            String type,
////                            String message){
////        System.out.println("发送消息体id:"+id);
////        System.out.println("发送消息体userName:"+userName);
////        System.out.println("发送消息体type:"+type);
////        System.out.println("发送消息体message:"+message);
////    }

    @MessageMapping("/sendMessage")
    public void sendMessage(Message message){
        System.out.println("发送消息体id:"+message);
        ws.sendMessage(message);
    }

    /**
     * @api {POST} /userInToRoom 用户进入房间
     * @apiGroup socket
     * @apiVersion 1.0.0
     * @apiDescription 接口说明
     * @apiParam {String} type 类型
     * @apiParam {String} roomSerial 房间序号
     * @apiParam {String} userId 用户Id
     * @apiParam {String} userImg 用户头像
     * @apiParam {String} userNickName 用户昵称
     * @apiParam {String} money 筹码
     * @apiParamExample {json} 请求样例：
     *                ?id=bfc5bd62010f467cbbe98c9e4741733b
     * @apiSuccess (200) {String} code 200:成功</br>
     *                                 404:机构不存在/ID为空</br>
     * @apiSuccess (200) {String} message 信息
     * @apiSuccess (200) {String} data 返回用户信息
     * @apiSuccessExample {json} 返回样例:
     * {
     * 	"code": 200,
     * 	"message": "登录成功",
     * 	"data": "{}"
     * }
     */
    @MessageMapping("/userInToRoom")
    public void inToRoom(Map<String,String> message){
        System.out.println("type:"+message.get("type"));
        System.out.println("userId:"+message.get("userId"));
        System.out.println("userImg:"+message.get("userImg"));
        //发送有人进入消息
        ws.sendUserInToRoomMessage(message);
        Room room =  ws.findRoomMessageByRoomSerial(message.get("roomSerial"));
        System.out.println("room:"+room);
        //所有桌子的信息
//        List<Seat> seats = ws.findSeatsByRoom(room);
//        System.out.println("seats:"+seats);
        //发送所有桌子的信息
        ws.sendRoomMessage(room,message);

    }



}
