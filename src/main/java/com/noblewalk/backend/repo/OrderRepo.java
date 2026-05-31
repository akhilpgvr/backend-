package com.noblewalk.backend.repo;

import com.noblewalk.backend.model.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepo extends MongoRepository<OrderEntity, String> {
    Optional<OrderEntity> findByOrderNumber(String orderNumber);
}
