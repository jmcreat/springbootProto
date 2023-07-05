package com.example.demo.svc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api")
    public class svcController {

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
            return ResponseEntity.ok(response);
        }

    }
