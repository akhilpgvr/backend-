package com.noblewalk.backend.repo;

import com.noblewalk.backend.model.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepo extends MongoRepository<OrderEntity, String> {
}
