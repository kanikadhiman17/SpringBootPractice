package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BrandControllerSave {

    @PostMapping("/addBrand")
    Brand addBrand(@RequestBody Brand brand);
    @PostMapping("/addBrands")
    List<Brand> addBrands(@RequestBody List<Brand> brands);

}


