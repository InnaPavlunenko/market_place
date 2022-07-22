package com.example.market_place.dto;

import com.example.market_place.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private double amountOfMoney;

}
