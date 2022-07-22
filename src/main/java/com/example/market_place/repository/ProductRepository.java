package com.example.market_place.repository;

import com.example.market_place.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository  extends MongoRepository<Product, ObjectId>  {

}
