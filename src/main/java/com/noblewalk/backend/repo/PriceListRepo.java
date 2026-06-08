package com.noblewalk.backend.repo;

import com.noblewalk.backend.model.entity.PriceListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceListRepo extends MongoRepository<PriceListEntity, String> {
    Optional<PriceListEntity> findByItemId(String itemId);
}
