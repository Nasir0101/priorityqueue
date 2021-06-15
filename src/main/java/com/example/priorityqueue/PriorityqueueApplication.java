package com.example.priorityqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class PriorityqueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriorityqueueApplication.class, args);
    }

}
