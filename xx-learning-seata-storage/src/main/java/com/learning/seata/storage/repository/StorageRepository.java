package com.learning.seata.storage.repository;

import com.learning.seata.storage.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<StorageEntity, Integer> {


}
