package com.kanika.spring.example.repository;

import com.kanika.spring.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Entity is Product, and primary ket is Integer
public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndQuantity(String name, int quantity);

    @Query(value = "SELECT DISTINCT * FROM product WHERE product.name LIKE %?1% ORDER BY product.price", nativeQuery = true)
    List<Product> getProductByName(String name);

}
