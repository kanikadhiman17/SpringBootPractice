package com.kanika.spring.example.repository;

import com.kanika.spring.example.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findByName(String name);
}
