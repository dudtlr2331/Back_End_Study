package org.example.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sseex02Application {

    public static void main(String[] args) {
        SpringApplication.run(Sseex02Application.class, args);
    }

}
