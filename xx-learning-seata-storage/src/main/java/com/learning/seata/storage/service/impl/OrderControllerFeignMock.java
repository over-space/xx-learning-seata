package com.learning.seata.storage.service.impl;

import com.learning.seata.feign.order.controller.OrderControllerFeign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Primary
@Component
@ConditionalOnProperty(name = "feign.dev.mode", havingValue = "true")
public class OrderControllerFeignMock implements OrderControllerFeign {

    @Override
    public ResponseEntity addOrderByUserId(Integer userId, String storageName) {
        System.out.println("-----------------------执行Feign Mock实现-------------------------------------------------");
        return new ResponseEntity(HttpStatus.OK);
    }
}
