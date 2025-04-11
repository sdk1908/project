package com.microservice.orderservice.controller;

import com.microservice.orderservice.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    UserFeign userFeign;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderById(@PathVariable("id") String id){

        return userFeign.getUserById(id);
       //  ResponseEntity.ok(""+);
       // return ResponseEntity.ok("Order "+id);
    }


}
