package com.wegame.wegameliveserviceall.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.wegame.wegameliveserviceall.entity.Room;
import com.wegame.wegameliveserviceall.entity.Seat;
import com.wegame.wegameliveserviceall.repository.RoomRepository;
import com.wegame.wegameliveserviceall.repository.SeatRepository;
import com.wegame.wegameliveserviceall.service.WebSocketService;
import com.wegame.wegameliveserviceall.utils.WebSocketParam;
import com.wegame.wegameliveserviceall.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public void sendMessage(Message message) {
//        OutMessage outMessage = new OutMessage();
//        outMessage.setCreatedDate(new Date());
//        outMessage.setLastModifiedDate(new Date());
//        outMessage.setContent(inMessage.getContent());
//        for (OutMessage.Message_TYPE messageType : OutMessage.Message_TYPE.values()){
//            if (messageType.ordinal()== inMessage.getType().getIndex()){
//                outMessage.setType(messageType);
//            }
//        }
//        template.convertAndSend("/friedFlower/one", new Message(1,inMessage.getContent()));

        template.convertAndSend("/friedFlower/one", WebSocketParam.userOutRoom("111","aaa"));
    }

    @Override
    public Room findRoomMessageByRoomSerial(String roomSerial) {
        Room room = roomRepository.findRoomMessageByRoomSerial(Integer.parseInt(roomSerial) );
        System.out.println("room:"+room);
        return room;
    }

    @Override
    public List<Seat> findSeatsByRoom(Room room) {
        List<Seat> seats = seatRepository.findSeatsByRoom(room);
        return seats;
    }

    @Override
    public void sendUserInToRoomMessage(Map<String, String> message) {
        template.convertAndSend("/friedFlower/"+WebSocketParam.serial(message.get("type")),
                WebSocketParam.userInToRoom(message.get("type"),
                                            message.get("userId"),
                                            message.get("userImg"),
                                            message.get("userNickName"),
                                            message.get("integral")));
    }

    @Override
    public void sendRoomMessage(Room room, Map<String, String> message) {

        System.out.println("11："+room.getStatus().ordinal());
        /* 0 未开始  1 一开始*/
//        if (0==room.getStatus().ordinal()){
//            //查询房间信息
////            List<Seat> seats =  seatRepository.findSeatsByRoom(room);
//            List<JSONObject> objects = seatRepository.findRoomNoStart(room.getSerial());
//            template.convertAndSend("/friedFlower/"+WebSocketParam.serial(message.get("type")),WebSocketParam.room("0",objects));
//        }else if (1==room.getStatus().ordinal()){
//            List<JSONObject> objects = seatRepository.findRoomIsStart(room.getSerial());
//            System.out.println("objects:"+objects);
//            template.convertAndSend("/friedFlower/"+WebSocketParam.serial(message.get("type")),WebSocketParam.room("0",objects));
//
//        }
        List<JSONObject> objects = seatRepository.findRoomInfo(room.getSerial());
        template.convertAndSend("/friedFlower/"+WebSocketParam.serial(message.get("type")),WebSocketParam.room("0",objects));
    }


}
