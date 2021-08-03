package com.learning.seata.feign.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-user")
public interface OrderControllerFeign {

    @GetMapping("/order/addOrderByUserId")
    ResponseEntity addOrderByUserId(@RequestParam("userId") Integer userId, @RequestParam("storageName") String storageName);
}
