package com.microservice.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface UserFeign {

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id);

}
