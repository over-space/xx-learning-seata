package com.learning.seata.user.service.impl;

import com.learning.seata.feign.storage.controller.MessageException;
import com.learning.seata.user.entity.OrderEntity;
import com.learning.seata.user.entity.UserEntity;
import com.learning.seata.user.repository.OrderRepository;
import com.learning.seata.user.repository.UserRepository;
import com.learning.seata.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrderByUserId(Integer userId, String storageName) {

        UserEntity userEntity = userRepository.findById(userId).orElse(null);

        if (userEntity == null) {
            throw new MessageException("非法用户!");
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(userId);
        orderEntity.setStorageName(storageName);
        orderRepository.save(orderEntity);
    }
}
