package com.noblewalk.backend.controller;

import com.noblewalk.backend.model.dtos.request.OrderRequest;
import com.noblewalk.backend.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "", description = "API got creating a sales Order")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest  orderRequest) {
        return new ResponseEntity<>(orderService.createOrder(orderRequest),  HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "API for deleting a sales order")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@RequestParam String  orderNumber) {
        return new ResponseEntity<>(orderService.deleteOrder(orderNumber), HttpStatus.OK);
    }

}
