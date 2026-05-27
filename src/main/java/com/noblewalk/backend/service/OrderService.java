package com.noblewalk.backend.service;

import com.noblewalk.backend.model.dtos.OrderRequest;
import com.noblewalk.backend.model.entity.OrderEntity;
import com.noblewalk.backend.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;

    public String createOrder(OrderRequest orderRequest) {
        OrderEntity order = new OrderEntity();
        try{
            modelMapper.map(orderRequest, order);
            order.setCreatedBy("Admin");
            order.setCreatedOn(LocalDateTime.now());
            order.setUpdatedBy("Admin");
            order.setUpdatedOn(LocalDateTime.now());
            orderRepo.save(order);
        }


        catch (Exception e){
            log.error("Exception in OrderService", e);
            return e.getMessage();
        }
        return "";
    }
}
