package com.learning.seata.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.learning.seata")
public class XxLearningSeataGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxLearningSeataGatewayApplication.class, args);
    }

}
