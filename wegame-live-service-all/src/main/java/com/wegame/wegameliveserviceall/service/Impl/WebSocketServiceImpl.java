package com.wegame.wegameliveserviceall.service.Impl;

import com.wegame.wegameliveserviceall.dto.Message;
import com.wegame.wegameliveserviceall.entity.InMessage;
import com.wegame.wegameliveserviceall.entity.OutMessage;
import com.wegame.wegameliveserviceall.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName：WebSocketServiceImpl
 * @Description: 即时通讯
 * @Author：13738700108
 * @Data 2020/2/12 14:41
 * @Version: v1.0
 **/
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public void sendMessage(InMessage inMessage) {
//        OutMessage outMessage = new OutMessage();
//        outMessage.setCreatedDate(new Date());
//        outMessage.setLastModifiedDate(new Date());
//        outMessage.setContent(inMessage.getContent());
//        for (OutMessage.Message_TYPE messageType : OutMessage.Message_TYPE.values()){
//            if (messageType.ordinal()== inMessage.getType().getIndex()){
//                outMessage.setType(messageType);
//            }
//        }
        template.convertAndSend("/topic/chat", new Message(inMessage.getType().getIndex(),inMessage.getContent()));
    }
}
