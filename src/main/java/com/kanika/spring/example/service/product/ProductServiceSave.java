package com.kanika.spring.example.service.product;

import com.kanika.spring.example.entity.Product;

import java.util.List;

public interface ProductServiceSave {

    Product saveProduct (Product product);
    List<Product> saveProducts (List<Product> products);

}
