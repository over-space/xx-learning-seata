package com.learning.seata.storage.service;

import com.learning.seata.storage.entity.StorageEntity;

public interface StorageService {

    void updateById(Integer id);

    StorageEntity getById(Integer id);

    void deductStorage(Integer id);

    void updateStorageAndBill();

    void addStorage(Integer id);
}
