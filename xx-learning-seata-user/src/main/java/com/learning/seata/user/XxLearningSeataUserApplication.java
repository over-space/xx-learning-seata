package com.learning.seata.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XxLearningSeataUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxLearningSeataUserApplication.class, args);
    }

}
