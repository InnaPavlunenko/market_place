package com.example.market_place.controller;


import com.example.market_place.dto.*;
import com.example.market_place.entity.User;
import com.example.market_place.service.SaleService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<ResponseMessage> saleProduct(@RequestBody SaleDto sales) {
        saleService.saleProduct(sales);
        ResponseMessage message = new ResponseMessage();
        message.setMessage("Successful purchase");
        return ResponseEntity.ok(message);
    }
    @GetMapping("/salesByUsers/{id}")
    public ResponseEntity<List<SaleResponseByUser>> getAll(@PathVariable("id") ObjectId userId) {
        return ResponseEntity.ok(saleService.getSaleByUserId(userId));
    }

    @GetMapping("/salesByProduct/{id}")
    public ResponseEntity<List<SaleResponseByProduct>> getAllSales(@PathVariable("id") ObjectId productId) {
        return ResponseEntity.ok(saleService.getSaleByProductId(productId));
    }
}
