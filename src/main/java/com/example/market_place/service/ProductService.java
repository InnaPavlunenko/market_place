package com.example.market_place.service;

import com.example.market_place.dto.ProductDto;
import com.example.market_place.entity.Product;
import com.example.market_place.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto createProduct(Product product) {
        product.setId(ObjectId.get());
        productRepository.save(product);
        ProductDto productResponse = new ProductDto();
        productResponse.setName(product.getName());
        productResponse.setId(product.getId().toString());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public List<ProductDto> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> products = new ArrayList<>();
        for(Product product: productList) {
            ProductDto productResponse = new ProductDto();
            productResponse.setName(product.getName());
            productResponse.setId(product.getId().toString());
            productResponse.setPrice(product.getPrice());
            products.add(productResponse);
        }
        return products;
    }
}
