package com.learning.seata.storage.repository;

import com.learning.seata.storage.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Integer> {


}
