package com.example.springaop.controller;

import com.example.springaop.model.Ping;
import com.example.springaop.service.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    @Autowired
    PingService pingService;

    @GetMapping
    public ResponseEntity<Ping> ping(@RequestParam(defaultValue = "false") boolean run) {
        Ping ping = null;

        if (run) {
            ping = pingService.getPing(true);
        } else {
            ping = pingService.getPing();
        }

        return ResponseEntity.ok(ping);
    }
}
