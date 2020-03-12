package com.example.springaop.service;

import com.example.springaop.model.Ping;
import org.springframework.stereotype.Service;

@Service
public class PingService {
    Ping ping;

    public PingService() {
        this.ping = new Ping("pong");
    }

    public Ping getPing() {
        return ping;
    }

    public Ping getPing(boolean run) {
        return ping;
    }
}
