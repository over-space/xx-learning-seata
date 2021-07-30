package com.learning.seata.user.controller;

import com.learning.seata.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/addOrderByUserId")
    public ResponseEntity addOrderByUserId(@RequestParam("userId") Integer userId,
                                           @RequestParam("storageName") String storageName) throws Exception {
        orderService.addOrderByUserId(userId, storageName);
        return new ResponseEntity(HttpStatus.OK);
    }

}
