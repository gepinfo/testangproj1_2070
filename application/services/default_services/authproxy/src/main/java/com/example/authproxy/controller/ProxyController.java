package com.example.authproxy.controller;

import com.example.authproxy.dto.UserDetails;
import com.example.authproxy.service.ProxyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class ProxyController {

    private final ProxyService proxyService;

    @Autowired
    public ProxyController(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    @PostMapping("/proxy")
    public ResponseEntity<Object> userController(@RequestBody UserDetails userDetails) {
        log.info("Entering ProxyController: userController");
        try {
            Object response = proxyService.userService(userDetails);
            log.info("Exiting ProxyController: userController");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error in ProxyController: {}", e.getMessage());
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }

}



