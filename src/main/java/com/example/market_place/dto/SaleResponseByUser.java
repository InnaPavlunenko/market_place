package com.example.market_place.dto;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SaleResponseByUser {
    private String productName;
    private String productId;
}
