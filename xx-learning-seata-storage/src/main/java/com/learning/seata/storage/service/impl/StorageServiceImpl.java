package com.learning.seata.storage.service.impl;

import com.learning.seata.storage.entity.StorageEntity;
import com.learning.seata.storage.repository.StorageRepository;
import com.learning.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

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
    public StorageEntity getById(Integer id) {
        return storageRepository.findById(id).orElse(null);
    }
}
