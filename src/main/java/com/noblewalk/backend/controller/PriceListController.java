package com.noblewalk.backend.controller;

import com.noblewalk.backend.model.dtos.request.PriceListRequest;
import com.noblewalk.backend.service.PriceListService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/priceList")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @Operation(summary = "", description = "API to create PriceList")
    @PostMapping("/create")
    public ResponseEntity<String> createPriceList(@RequestBody PriceListRequest request) {
        return new ResponseEntity<>( priceListService.createPriceList(request), HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "API to update PriceList")
    @PostMapping("/update")
    public ResponseEntity<String> UpdatePriceList(@RequestBody PriceListRequest request) {
        return new ResponseEntity<>(priceListService.updatePriceList(request), HttpStatus.CREATED);
    }

    @Operation(summary = "", description = "API to get the PriceList")
    @GetMapping("/get")
    public ResponseEntity<PriceListRequest> getPriceList(@RequestParam String ItemId) {
        return new ResponseEntity<>(priceListService.getPriceList(ItemId), HttpStatus.OK);
    }
}
