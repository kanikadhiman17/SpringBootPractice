package com.kanika.spring.example.controller;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // SpringFramework - Talks to service class
public class ProductController {

    @Autowired // SpringFramework.beans
    private ProductService productService;

    // For POST API
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    // For GET API
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/productByIds") //productByIds?id=1,2,3 OR productByIds?id=1&id=2
    public List<Product> findProductByIds(@RequestParam(name="id") List<Integer> ids) {
        return productService.getProductByIds(ids);
    }

    // Query Parameters /product?name=something&quantity=2
    @GetMapping("/productByNameAndQuantity")
    public List<Product> findProductByNameAndQuantity(@RequestParam(name = "name") String name, @RequestParam(name = "quantity") int quantity)  {
        return productService.getProductByNameAndQuantity(name, quantity);
    }

    // For PUT API
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    // For DELETE API
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    // GET Substring: Stream
    @GetMapping("/productByName/{name}")
    public List<String> findProductByNameUsingStream(@PathVariable String name) {
        return productService.searchProductByNameUsingStream(name);
    }

    // GET Substring: SQL
    @GetMapping("/productByNameSQL/{name}")
    public List<String> findProductByNameUsingSQL(@PathVariable String name) {
        return productService.searchProductByNameUsingSQL(name);
    }

    /*// GET Substring: Completable Future
    @GetMapping("/productUsingCF/{name}")
    public List<String> findProductBySubstringUsingCF(@PathVariable String name) {
        return productService.searchProductByNameUsingCF(name);
    }*/

    // GET Substring: Stream
    @GetMapping("/productByBrand/{name}")
    public List<String> findProductByBrand(@PathVariable String name) {
        return productService.searchProductByBrand(name);
    }

}
