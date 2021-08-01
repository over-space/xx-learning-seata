package com.learning.seata.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(value = "com.learning.seata.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class XxLearningSeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxLearningSeataStorageApplication.class, args);
    }

}
