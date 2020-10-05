package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductControllerSave {

    @PostMapping("/addProduct")
    Product addProduct(@RequestBody Product product);
    @PostMapping("/addProducts")
    List<Product> addProducts(@RequestBody List<Product> products);
}
