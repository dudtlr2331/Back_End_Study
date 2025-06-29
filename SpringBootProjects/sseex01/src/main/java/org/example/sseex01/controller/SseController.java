package org.example.sseex01.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.awt.*;
import java.io.IOException;

@Controller
public class SseController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping( path = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter sendSSE(){
        SseEmitter emitter = new SseEmitter();

        new Thread(() -> {
            try {
                    for (int i=1; i <= 3; i++){
                        emitter.send(SseEmitter.event().data("Hello : " + System.currentTimeMillis()));
                        Thread.sleep(1000);
                    }
                    emitter.complete();
                } catch (IOException | InterruptedException e) {
                    emitter.completeWithError(e);
                }
        }).start();

//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    for (int i=1; i <= 3; i++){
//                        emitter.send(SseEmitter.event().data("Hello : " + System.currentTimeMillis()));
//                        Thread.sleep(1000);
//                    }
//                    emitter.complete();
//                } catch (IOException | InterruptedException e) {
//                    emitter.completeWithError(e);
//                }
//            }
//        }).start();

        return emitter;
    }
}
