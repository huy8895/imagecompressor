package com.app.imagecompressor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/ping")
public class HealthController {

    @PostMapping("/v1")
    public Object ping() {
        log.info("start ping....");
        return "pong";
    }
}
