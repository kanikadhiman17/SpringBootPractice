package com.kanika.spring.example.service;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // POST Method
    public Product saveProduct (Product product) {
       return productRepository.save(product);
    }

    // POST Method
    public List<Product> saveProducts (List<Product> products) {
        return productRepository.saveAll(products);
    }

    // GET all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // GET based on ID
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // GET based on ID
    public List<Product> getProductByIds(List<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    // GET based on name and quantity
    public List<Product> getProductByNameAndQuantity(String name, int quantity) {
        return productRepository.findByNameAndQuantity(name, quantity);
    }

    // DELETE
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product removed !! " + id;
    }

    // PUT
    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setBrand(product.getBrand());
        return productRepository.save(existingProduct);
    }

    // GET using Stream
    public List<String> searchProductByNameUsingStream(String name)
    {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.parallelStream()
                .filter(p -> p.getName().contains(name))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    public List<String> searchProductByBrand(String name) {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.parallelStream()
                .filter(p -> p.getBrand().getName().contains(name))
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    public List<String> searchProductByNameUsingSQL(String name) {
        List<Product> matchedProducts = productRepository.getProductByName(name);
        return matchedProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    /*// Get using CompletableFuture
    public List<String> searchProductByNameUsingCF(String name) {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.stream()
                .filter(p -> CompletableFuture.supplyAsync(() -> p.getName().contains(name)).get()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList()));

        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());

    }*/

    // Get using JPA Query
}
