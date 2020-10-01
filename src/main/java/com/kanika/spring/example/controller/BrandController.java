package com.kanika.spring.example.controller;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    @Autowired // SpringFramework.beans
    private BrandService brandService;

    // For POST API
    @PostMapping("/addBrand")
    public Brand addBrand(@RequestBody Brand brand) {
        return brandService.saveBrand(brand); // Shows saved brand
    }

    @PostMapping("/addBrands")
    public List<Brand> addBrands(@RequestBody List<Brand> brands) {
        return brandService.saveBrands(brands);
    }

    // For GET API
    @GetMapping("/brands")
    public List<Brand> findAllBrands() {
        return brandService.getBrands();
    }

    @GetMapping("/brandById/{id}")
    public Brand findBrandById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @GetMapping("/brandByIds")
    public List<Brand> findBrandByIds(@RequestParam(name="id") List<Integer> ids) {
        return brandService.getBrandByIds(ids);
    }

    @GetMapping("/brandByName/{name}")
    public List<Brand> findBrandByName(@PathVariable String name) {
        return brandService.getBrandByName(name);
    }

    // For PUT API
    @PutMapping("/updateBrand")
    public Brand updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    // For DELETE API
    @DeleteMapping("/deleteBrand/{id}")
    public String deleteBrand(@PathVariable int id) {
        return brandService.deleteBrand(id);
    }
}
