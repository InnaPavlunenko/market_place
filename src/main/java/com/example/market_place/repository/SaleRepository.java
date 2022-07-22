package com.example.market_place.repository;

import com.example.market_place.entity.Sale;
import com.example.market_place.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SaleRepository extends MongoRepository<Sale, ObjectId> {

    List<Sale> findAllByUserId(ObjectId userId);

    List<Sale> findAllByProductId(ObjectId productId);
}
