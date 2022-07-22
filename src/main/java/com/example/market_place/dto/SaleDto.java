package com.example.market_place.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SaleDto {
    private ObjectId productId;
    private ObjectId userId;
}
