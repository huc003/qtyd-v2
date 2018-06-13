package com.websocket.core.job;

import com.websocket.core.tools.SimpMessagingTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/6/13
 * @Description: 类描述
 **/
@Component
public class WebSocketJob {

    @Autowired
    private SimpMessagingTools simpMessagingTools;

    @Scheduled(cron = "0/10 * * * * ? ")
    private void sendMessage(){
        simpMessagingTools.send("每10秒推送消息给客户端");
    }
}
