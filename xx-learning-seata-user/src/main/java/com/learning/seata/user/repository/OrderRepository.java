package com.learning.seata.user.repository;

import com.learning.seata.user.entity.OrderEntity;
import com.learning.seata.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
