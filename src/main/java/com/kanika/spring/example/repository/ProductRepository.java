package com.kanika.spring.example.repository;

import com.kanika.spring.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Entity is Product, and primary ket is Integer
public interface ProductRepository extends JpaRepository<Product,Integer> {
    //List<Product> findByName(String name);
    @Query(value = "SELECT * FROM product p, brand b WHERE p.name LIKE %?1% AND b.name LIKE %?2% AND b.id = p.fk_brand", nativeQuery = true)
    Page<Product> findByNameAndBrand(String name, String brand, Pageable page);



    /*@Query(value = "SELECT DISTINCT * FROM product WHERE product.name LIKE %?1% ORDER BY product.price", nativeQuery = true)
    List<Product> getProductByName(String name);*/

}
