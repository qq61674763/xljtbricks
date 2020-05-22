package com.bricks.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);
    }

}
