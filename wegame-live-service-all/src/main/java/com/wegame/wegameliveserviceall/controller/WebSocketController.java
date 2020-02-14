package com.wegame.wegameliveserviceall.controller;

import com.wegame.wegameliveserviceall.entity.InMessage;
import com.wegame.wegameliveserviceall.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void sendMessage1(InMessage inMessage){
        System.out.println("发送消息体id:"+inMessage);
        System.out.println("发送消息体id:"+inMessage.getType());
        System.out.println("发送消息体id:"+inMessage.getFromId());
        System.out.println("发送消息体id:"+inMessage.getContent());
        System.out.println("发送消息体id:"+inMessage.getTime());
        ws.sendMessage(inMessage);
    }


}
