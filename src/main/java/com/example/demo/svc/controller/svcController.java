package com.example.demo.svc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

    @RestController
    @RequestMapping("/api")
    public class svcController {
        private static final Logger logger = LogManager.getLogger(svcController.class);
        @GetMapping("/endpoint")
        public ResponseEntity<String> getEndpoint() {
            // 처리 로직 구현
            String response = "Hello, World!";
            return ResponseEntity.ok(response);
        }

        @GetMapping("/endpoint1")
        public ResponseEntity<String> getEndpoint1() {
            // 처리 로직 구현
            String response = "getEndpoint2";
            logger.debug("Debug message");
            logger.info("Info message");
            logger.warn("Warning message");
            logger.error("Error message");
            return ResponseEntity.ok(response);
        }
        @GetMapping("/topic/messages")
        public ResponseEntity<String> getEndpoint2() {
            // 처리 로직 구현
            String response = "topic messages";
            return ResponseEntity.ok(response);
        }
    }
