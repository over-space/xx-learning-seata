package com.learning.seata.storage.service.impl;

import com.learning.logger.annotation.Logger;
import com.learning.logger.core.LoggerAspect;
import com.learning.seata.feign.order.controller.OrderControllerFeign;
import com.learning.seata.feign.storage.controller.MessageException;
import com.learning.seata.storage.entity.BillEntity;
import com.learning.seata.storage.entity.StorageEntity;
import com.learning.seata.storage.repository.BillRepository;
import com.learning.seata.storage.repository.StorageRepository;
import com.learning.seata.storage.service.StorageService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private OrderControllerFeign orderControllerFeign;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(Integer id) {
        StorageEntity storageEntity = storageRepository.findById(id).orElse(null);

        if(storageEntity == null){
            return;
        }

        int count = storageEntity.getCount();

        storageEntity.setCount(count++);

        storageRepository.save(storageEntity);
    }

    @Override
    @Logger
    @GlobalLock
    public StorageEntity getById(Integer id) {
        return storageRepository.findById(id).orElse(null);
    }

    @Override
    @Logger
    // @Transactional(rollbackFor = Exception.class)
    @GlobalTransactional(rollbackFor = Exception.class)
    public void deductStorage(Integer id) {
        StorageEntity storageEntity = storageRepository.findById(id).orElse(null);

        if(storageEntity == null){
            throw new MessageException("未知的商品！");
        }

        int count = storageEntity.getCount();
        if(count <= 0) {
            throw new MessageException("库存不足！");
        }
        storageEntity.setCount(count - 1);
        storageRepository.save(storageEntity);

        orderControllerFeign.addOrderByUserId(1, storageEntity.getName());

        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 100 / 0;
    }

    @Override
    @GlobalLock
    public void addStorage(Integer id) {
        StorageEntity storageEntity = storageRepository.findById(id).orElse(null);

        if(storageEntity == null){
            throw new MessageException("未知的商品！");
        }

        int count = storageEntity.getCount();
        storageEntity.setCount(count + 1);
        storageRepository.save(storageEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateStorageAndBill() {
        StorageEntity storageEntity = storageRepository.findById(1).orElse(null);

        if(storageEntity == null){
            throw new MessageException("未知的商品！");
        }
        int count = storageEntity.getCount();
        storageEntity.setCount(count + 100);
        storageRepository.save(storageEntity);

        BillEntity billEntity = new BillEntity();
        billEntity.setCreatedDateTime(LocalDateTime.now());
        billEntity.setTime(LocalTime.now());
        billEntity.setName(String.valueOf(new Random().nextInt(10000)));
        billRepository.save(billEntity);
    }
}
