package com.kanika.spring.example.service.product;

import com.kanika.spring.example.entity.Product;
import com.kanika.spring.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceSearchImpl implements ProductServiceSearch {

    private final ProductRepository productRepository;

    //@Autowired
    public ProductServiceSearchImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GET all products
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // GET all products by Id
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    // GET all products by IDs
    @Override
    public List<Product> getProductByIds(List<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    // GET product based on name and quantity
    @Override
    public List<Product> getProductByNameAndQuantity(String name, int quantity) {
        return productRepository.findByNameAndQuantity(name, quantity);
    }

    // GET product from name using Stream
    @Override
    public List<String> getProductByNameUsingStream(String name)
    {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.parallelStream()
                .filter(p -> p.getName().contains(name))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
        // TODO: DTOs
        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    // Get product from brand using Parallel Stream
    @Override
    public List<String> getProductByBrand(String name) {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.parallelStream()
                .filter(p -> p.getBrand().getName().contains(name))
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        // TODO: DTOs
        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    // Get product from name using JPA Query
    @Override
    public List<String> getProductByNameUsingSQL(String name) {
        List<Product> matchedProducts = productRepository.getProductByName(name);
        // TODO: DTOs
        return matchedProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());
    }

    /*// Get product from name using CompletableFuture
    @Override
    public List<String> getProductByNameUsingCF(String name) {
        List<Product> allProducts = productRepository.findAll();
        allProducts = allProducts.stream()
                .filter(p -> CompletableFuture.supplyAsync(() -> p.getName().contains(name)).get()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList()));

        return allProducts.stream()
                .map(o-> (o.getBrand().getName() + ", " + o.getName() + ", Rs."+o.getPrice()))
                .collect(Collectors.toList());

    }*/
}
