package com.learning.seata.user.controller;

import com.learning.seata.feign.order.controller.OrderControllerFeign;
import com.learning.seata.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderControllerFeign {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity addOrderByUserId(@RequestParam("userId") Integer userId,
                                           @RequestParam("storageName") String storageName) {
        orderService.addOrderByUserId(userId, storageName);
        return new ResponseEntity(HttpStatus.OK);
    }

}
