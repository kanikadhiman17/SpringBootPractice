package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductControllerSearch {

    @GetMapping("/products")
    List<Product> findAllProducts();
    @GetMapping("/productById/{id}")
    Product findProductById(@PathVariable int id);
    @GetMapping("/productByIds") //productByIds?id=1,2,3 OR productByIds?id=1&id=2
    List<Product> findProductByIds(@RequestParam(name="id") List<Integer> ids);
    @GetMapping("/productByNameAndQuantity")    // Query Parameters /product?name=something&quantity=2
    List<Product> findProductByNameAndQuantity(@RequestParam(name = "name") String name, @RequestParam(name = "quantity") int quantity);
    @GetMapping("/productByNameStream/{name}")
    List<String> findProductByNameUsingStream(@PathVariable String name);
    @GetMapping("/productByNameSQL/{name}")
    List<String> findProductByNameUsingSQL(@PathVariable String name);
    //@GetMapping("/productByNameCF/{name}")
    //List<String> findProductBySubstringUsingCF(@PathVariable String name);
    @GetMapping("/productByBrand/{name}")
    List<String> findProductByBrand(@PathVariable String name);

}
