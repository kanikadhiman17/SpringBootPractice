package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceSave;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductControllerSave{

    private final ProductServiceSave productServiceSave;

    //@Autowired
    public ProductControllerSave(ProductServiceSave productServiceSave) {
        this.productServiceSave = productServiceSave;
    }

    /*@PostMapping
    Product addProduct(@RequestBody Product product) {
        return productServiceSave.saveProduct(product);
    }*/

    @PostMapping
    List<Product> addProducts(@RequestBody List<Product> products) {
        return productServiceSave.saveProducts(products);
    }
}
