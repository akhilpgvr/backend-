package com.noblewalk.backend.service;

import com.noblewalk.backend.exceptions.OrderNotCreatedException;
import com.noblewalk.backend.exceptions.OrderNotFoundException;
import com.noblewalk.backend.model.dtos.OrderRequest;
import com.noblewalk.backend.model.entity.OrderEntity;
import com.noblewalk.backend.repo.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.noblewalk.backend.Helper.generateOrderNumber;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;

    public OrderEntity getOrder(String orderNumber){

        log.info("Get order for order number {}", orderNumber);
        Optional<OrderEntity> order = orderRepo.findByOrderNumber(orderNumber);
        if(order.isEmpty()) throw new OrderNotFoundException("Order: "+ orderNumber+ " Not Found");
        return order.get();
    }
    public String createOrder(OrderRequest orderRequest) {
        OrderEntity order = new OrderEntity();
        try{
//            Todo Akhil -- add check for pricelist of item
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

    public String deleteOrder(String orderNumber) {

        OrderEntity order = getOrder(orderNumber);
        log.info("Delete order for order number {}", orderNumber);
        orderRepo.delete(order);
        return "S";
    }
}
