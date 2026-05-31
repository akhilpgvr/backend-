package com.noblewalk.backend.controller;

import com.noblewalk.backend.model.dtos.OrderRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priceList")
public class PriceListController {

    @Operation()
    @PostMapping("/create")
    public ResponseEntity<String> createPriceList(@RequestBody OrderRequest orderRequest) {
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}
