package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerUpdate {

    private final ProductServiceUpdate productServiceUpdate;

    @Autowired
    public ProductControllerUpdate(ProductServiceUpdate productServiceUpdate) {
        this.productServiceUpdate = productServiceUpdate;
    }

    @PutMapping
    Product updateProduct(@RequestBody Product product) {
        return productServiceUpdate.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    String deleteProduct(@PathVariable int id) {
        return productServiceUpdate.deleteProduct(id);
    }
}
