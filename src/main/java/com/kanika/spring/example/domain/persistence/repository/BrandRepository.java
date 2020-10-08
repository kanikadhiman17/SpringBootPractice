package com.kanika.spring.example.domain.persistence.repository;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand findByName(String name); // Not list because brand name is unique
}
