package com.example.demo.webSocket;

import com.example.demo.svc.controller.svcController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class WebSocketController {
    private static final Logger logger = LogManager.getLogger(svcController.class);
    @MessageMapping("/websocket")
    @SendTo("/topic/websocket")
    public String handleWebSocketMessage(String message) {
        // 메시지 핸들링 로직
        logger.info("test");
        logger.info(message);

        return message;
    }

    @MessageMapping("/test")
    public String handletopicMessage(String message) {
        // 메시지 핸들링 로직
        logger.info("handletopicMessage");
        logger.info(message);

        return message;
    }
//    @Scheduled(fixedRate = 5000)
    public String test() {
        // 메시지 핸들링 로직
        logger.info("test");
        return "hi";
    }
}