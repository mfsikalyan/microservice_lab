package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient("car-service")
@FeignClient("item-catlog")
interface CarClient {

    @GetMapping("/cars")
    @CrossOrigin
    Page<Car> readCars(Pageable pageable);
}