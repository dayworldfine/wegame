package com.wegame.wegameliveserviceall.service;

import com.wegame.wegameliveserviceall.entity.InMessage;

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
    void sendMessage(InMessage inMessage);
}
