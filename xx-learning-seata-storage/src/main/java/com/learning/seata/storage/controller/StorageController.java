package com.learning.seata.storage.controller;


import com.learning.seata.feign.storage.controller.StorageControllerFeign;
import com.learning.seata.storage.entity.StorageEntity;
import com.learning.seata.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StorageController implements StorageControllerFeign {

    @Autowired
    private StorageService storageService;


    @GetMapping("/storage/getById")
    public ResponseEntity<StorageEntity> getById(@RequestParam Integer id){
        StorageEntity storageEntity = storageService.getById(id);
        return new ResponseEntity<>(storageEntity, HttpStatus.OK);
    }

    @Override
    public void updateStorageAndBill(){
        storageService.updateStorageAndBill();
    }

    @Override
    public void deductStorage(Integer id) {
        storageService.deductStorage(id);
    }

    @Override
    public void addStorage(Integer id) {
        storageService.addStorage(id);
    }
}
