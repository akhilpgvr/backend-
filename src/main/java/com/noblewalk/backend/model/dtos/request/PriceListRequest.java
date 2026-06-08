package com.noblewalk.backend.model.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceListRequest {

    private String itemId;
    private double price;
    private int discount;
    private double offerPrice;
}
