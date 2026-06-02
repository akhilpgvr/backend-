package com.noblewalk.backend.model.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private String userMobileNo;
    private String userMailId;
    private String userName;
    private List<String> ItemNames;
    private Double totalPrice;
    private String deliveryAddress;
}
