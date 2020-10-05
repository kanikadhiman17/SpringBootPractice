package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BrandControllerSearch {

    @GetMapping("/brands")
    List<Brand> findAllBrands();
    @GetMapping("/brandById/{id}")
    Brand findBrandById(@PathVariable int id);
    @GetMapping("/brandByIds")
    List<Brand> findBrandByIds(@RequestParam(name = "id") List<Integer> ids);
    @GetMapping("/brandByName/{name}")
    List<Brand> findBrandByName(@PathVariable String name);
}
