package com.kanika.spring.example.domain.persistence.repository;

import com.kanika.spring.example.domain.persistence.entity.Product;
//import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Entity is Product, and primary key is Integer
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {

    /*@Query(value = "SELECT DISTINCT * FROM product WHERE product.name LIKE %?1% ORDER BY product.price", nativeQuery = true)
    List<Product> getProductByName(String name, Pageable page);*/

}
