package com.example.market_place.controller;

import com.example.market_place.dto.ProductDto;
import com.example.market_place.entity.Product;
import com.example.market_place.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")

public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
}
