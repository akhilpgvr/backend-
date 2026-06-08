package com.noblewalk.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "sales orders")
public class OrderEntity {

    @Id
    @Generated
    private String id;

    private String orderNumber;
    private String userMobileNo;
    private String userMailId;
    private String userName;
    private HashMap<String, Integer> Items;
    private Double totalPrice;
    private String deliveryAddress;
    private Date orderedDate;

    private LocalDateTime createdOn;
    private String createdBy;
    private LocalDateTime updatedOn;
    private String updatedBy;
}
