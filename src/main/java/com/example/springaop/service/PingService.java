package com.example.springaop.service;

import com.example.springaop.model.Ping;
import org.springframework.stereotype.Service;

@Service
public class PingService {
    public Ping getPing() {
        Ping ping = new Ping("pong");

        return ping;
    }
}
