package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface BrandControllerUpdate {

    @PutMapping("/updateBrand")
    public abstract Brand updateBrand(@RequestBody Brand brand);
    @DeleteMapping("/deleteBrand/{id}")
    public abstract String deleteBrand(@PathVariable int id);
}
