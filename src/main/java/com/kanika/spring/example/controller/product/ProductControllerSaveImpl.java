package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceSave;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerSaveImpl implements ProductControllerSave{

    private final ProductServiceSave productServiceSave;

    //@Autowired
    public ProductControllerSaveImpl(ProductServiceSave productServiceSave) {
        this.productServiceSave = productServiceSave;
    }

    // POST API
    @Override
    public Product addProduct(Product product) {
        return productServiceSave.saveProduct(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        return productServiceSave.saveProducts(products);
    }
}
