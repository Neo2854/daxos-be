package com.sekai.daxos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.sekai.daxos")
public class DaxosApplication {
    public static void main(String[] args) {
        SpringApplication.run(DaxosApplication.class, args);
    }
}
