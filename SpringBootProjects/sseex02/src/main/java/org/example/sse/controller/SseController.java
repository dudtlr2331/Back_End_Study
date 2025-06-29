package org.example.sse.controller;

import org.example.sse.service.SseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class SseController {

    @Autowired
    private SseService sseService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping( path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sendSSE() {
        // 만료시간 설정(spring boot : 30초)
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        sseService.addEmitter(emitter);
        sseService.sendEvents();

        return emitter;
    }
}
