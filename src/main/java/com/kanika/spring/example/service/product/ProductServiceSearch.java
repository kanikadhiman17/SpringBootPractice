package com.kanika.spring.example.service.product;

import com.kanika.spring.example.entity.Product;

import java.util.List;

public interface ProductServiceSearch {

    List<Product> getProducts();
    Product getProductById(int id);
    List<Product> getProductByIds(List<Integer> ids);
    List<Product> getProductByNameAndQuantity(String name, int quantity);
    List<String> getProductByNameUsingStream(String name);
    List<String> getProductByBrand(String name);
    List<String> getProductByNameUsingSQL(String name);
    //List<String> getProductByNameUsingCF(String name);

}
