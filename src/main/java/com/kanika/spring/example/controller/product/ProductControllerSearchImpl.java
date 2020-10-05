package com.kanika.spring.example.controller.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.product.ProductServiceSearch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerSearchImpl implements ProductControllerSearch {

    private final ProductServiceSearch productServiceSearch;

    //@Autowired
    public ProductControllerSearchImpl(ProductServiceSearch productServiceSearch) {
        this.productServiceSearch = productServiceSearch;
    }

    // GET API
    // TODO: Pagination
    @Override
    public List<Product> findAllProducts() {
        return productServiceSearch.getProducts();
    }

    @Override
    public Product findProductById(int id) {
        return productServiceSearch.getProductById(id);
    }

    @Override
    public List<Product> findProductByIds(List<Integer> ids) {
        return productServiceSearch.getProductByIds(ids);
    }

    @Override
    public List<Product> findProductByNameAndQuantity(String name, int quantity) {
        return productServiceSearch.getProductByNameAndQuantity(name, quantity);
    }

    @Override
    public List<String> findProductByNameUsingStream(String name) {
        return productServiceSearch.getProductByNameUsingStream(name);
    }

    @Override
    public List<String> findProductByNameUsingSQL(String name) {
        return productServiceSearch.getProductByNameUsingSQL(name);
    }

    /* @Override
    public List<String> findProductBySubstringUsingCF(@PathVariable String name) {
        return productServiceSearch.getProductByNameUsingCF(name);
    }*/

    @Override
    public List<String> findProductByBrand(@PathVariable String name) {
        return productServiceSearch.getProductByBrand(name);
    }
}
