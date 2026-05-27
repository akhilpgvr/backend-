package com.noblewalk.backend.controller;

import com.noblewalk.backend.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "", description = "Endpoint to get the suggested specialist")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(String itemName){
        return new ResponseEntity<>(orderService.createOrder(itemName),  HttpStatus.OK);
    }


}
