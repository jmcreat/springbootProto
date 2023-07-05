package com.example.demo.webSocket;
import com.example.demo.svc.controller.svcController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import org.springframework.messaging.support.MessageBuilder;

import javax.rmi.CORBA.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    private static final Logger logger = LogManager.getLogger(svcController.class);
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String sessionId = session.getId();
        sessions.put(sessionId,session);
        // WebSocket 연결이 수립되었을 때 실행되는 로직
        logger.info("afterConnectionEstablished");
        logger.info(sessionId);
        logger.info(sessions.values());
        sessions.values().forEach(s->{
            try{
                logger.info("sessinos values paramer : "+s);
                if(!s.getId().equals(sessionId)){
                    s.sendMessage(new TextMessage(("i am join "+s.getId())));
                }
            }catch(Exception e){
                logger.info(e);
            }
        });

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 텍스트 메시지를 수신받았을 때 실행되는 로직
        logger.info(message);
        logger.info("handleTextMessage");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("afterConnectionClosed");
        // WebSocket 연결이 종료되었을 때 실행되는 로직
    }
    // 필요한 다른 메서드들을 오버라이드하여 추가적인 로직을 구현할 수 있습니다.
}