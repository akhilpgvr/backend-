package com.noblewalk.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "item price-list")
public class PriceListEntity {
    @Id
    private String id;

    private String itemId;
    private double price;
    private int discount;
    private double offerPrice;
}
