package com.wegame.contreoller;

import com.wegame.model.Room;
import com.wegame.service.FriedFlowerService;
import com.wegame.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class FriedFlowerMegController {

    @Autowired
    private FriedFlowerService ffs;

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
    public Message sendMessage(Message message){
        System.out.println("发送消息体id:"+message);
        ffs.sendMessage(message);
        return message;
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
    public String inToRoom(Map<String,Object> msg){
        //发送有人进入消息
        ffs.sendUserInToRoomMessage(msg);
        Room room =  ffs.findRoomMessageByRoomSerial(Integer.parseInt(msg.get("roomSerial").toString()) );
        //所有桌子的信息
        //发送所有桌子的信息
        ffs.sendRoomMessage(room,msg);
        return "asdasdaxzc";
    }





}
