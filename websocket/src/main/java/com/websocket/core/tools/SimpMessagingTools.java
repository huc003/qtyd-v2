package com.websocket.core.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/6/13
 * @Description: 类描述
 **/
@Component
public class SimpMessagingTools {

    @Autowired
    public SimpMessagingTemplate template;

    public void send(String message){
        template.convertAndSend("/topic/getResponse", message);
    }

    public void sendToUser(String user,String message){
        template.convertAndSendToUser(user,"/message",message);
    }
}
