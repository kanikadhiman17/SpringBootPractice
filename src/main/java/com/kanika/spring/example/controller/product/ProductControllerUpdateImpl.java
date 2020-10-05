package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductControllerUpdateImpl implements ProductControllerUpdate {

    private final ProductServiceUpdate productServiceUpdate;

    @Autowired
    public ProductControllerUpdateImpl(ProductServiceUpdate productServiceUpdate) {
        this.productServiceUpdate = productServiceUpdate;
    }

    // PUT API
    @Override
    public Product updateProduct(Product product) {
        return productServiceUpdate.updateProduct(product);
    }

    // DELETE API
    @Override
    public String deleteProduct(int id) {
        return productServiceUpdate.deleteProduct(id);
    }
}
