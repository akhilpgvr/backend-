package com.noblewalk.backend.service;

import com.noblewalk.backend.Helper;
import com.noblewalk.backend.exceptions.OrderNotCreatedException;
import com.noblewalk.backend.model.dtos.OrderRequest;
import com.noblewalk.backend.model.entity.OrderEntity;
import com.noblewalk.backend.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.noblewalk.backend.Helper.generateOrderNumber;

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
            order.setOrderNumber(generateOrderNumber(orderRequest.getUserMobileNo()));
            orderRepo.save(order);
        }


        catch (Exception e){
            log.error("Exception in OrderService", e);
            throw new OrderNotCreatedException(e.getMessage());
        }
        return "S";
    }
}
