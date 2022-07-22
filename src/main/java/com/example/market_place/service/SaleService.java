package com.example.market_place.service;

import com.example.market_place.dto.ProductDto;
import com.example.market_place.dto.SaleDto;
import com.example.market_place.dto.SaleResponseByProduct;
import com.example.market_place.dto.SaleResponseByUser;
import com.example.market_place.entity.Product;
import com.example.market_place.entity.Sale;
import com.example.market_place.entity.User;
import com.example.market_place.repository.ProductRepository;
import com.example.market_place.repository.SaleRepository;
import com.example.market_place.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    public void saleProduct(SaleDto sales) {

        Optional<User> userOptional = userRepository.findById(sales.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Product> productOptional = productRepository.findById(sales.getProductId());

            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                if (product.getPrice() <= user.getAmountOfMoney()) {
                    Sale sale = new Sale();
                    sale.setId(ObjectId.get());
                    sale.setUserId(user.getId());
                    sale.setProductId(product.getId());
                    saleRepository.save(sale);

                    double amount = user.getAmountOfMoney();
                    user.setAmountOfMoney(amount -product.getPrice());
                    userRepository.save(user);
                } else {
                    throw new RuntimeException("insufficient funds");
                }
            }
            else {
                throw new RuntimeException("No product found");
            }
        }
        else {
            throw new RuntimeException("No user found");
        }

    }

    public List<SaleResponseByUser> getSaleByUserId(ObjectId userId) {
        List<Sale> sales = saleRepository.findAllByUserId(userId);
        List<SaleResponseByUser> products = new ArrayList<>();
        for(Sale sale: sales) {
            SaleResponseByUser saleResponse = new SaleResponseByUser();
            Product product = productRepository.findById(sale.getProductId()).get();
            saleResponse.setProductName(product.getName());
            saleResponse.setProductId(product.getId().toString());
            products.add(saleResponse);
        }
        return products;
    }

    public List<SaleResponseByProduct> getSaleByProductId(ObjectId productId) {
        List<Sale> sales = saleRepository.findAllByProductId(productId);
        List<SaleResponseByProduct> users = new ArrayList<>();
        for(Sale sale: sales) {
            SaleResponseByProduct saleResponse = new SaleResponseByProduct();
            User user = userRepository.findById(sale.getUserId()).get();
            saleResponse.setUserFirstName(user.getFirstName());
            saleResponse.setUserLastName(user.getLastName());
            saleResponse.setUserId(user.getId().toString());
            users.add(saleResponse);
        }
        return users;
    }
}
