package com.learning.seata.feign.storage.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-storage")
public interface StorageControllerFeign {

    @GetMapping(value = "/storage/deductStorage")
    void deductStorage(@RequestParam("id") Integer id);


}
