package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductControllerUpdate {

    @PutMapping("/updateProduct")
    Product updateProduct(@RequestBody Product product);
    @DeleteMapping("/deleteProduct/{id}")
    String deleteProduct(@PathVariable int id);
}
