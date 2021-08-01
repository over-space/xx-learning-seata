package com.learning.seata.user.service;

public interface OrderService {

    void addOrderByUserId(Integer userId, String storageName);

}
