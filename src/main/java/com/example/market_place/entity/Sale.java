package com.example.market_place.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sales")
public class Sale {

    @Id
    private ObjectId id;
    private ObjectId productId;
    private ObjectId userId;
}
