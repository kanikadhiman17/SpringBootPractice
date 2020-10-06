package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceSave;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandControllerSave{

    private final BrandServiceSave brandServiceSave;

    //@Autowired
    public BrandControllerSave(BrandServiceSave brandServiceSave) {
        this.brandServiceSave = brandServiceSave;
    }

    /*
    @PostMapping("")
    public Brand addBrand(@RequestBody Brand brand) {
        return brandServiceSave.saveBrand(brand); // Shows saved brand
    }*/

    @PostMapping
    public List<Brand> addBrands(@RequestBody List<Brand> brands) {
        return brandServiceSave.saveBrands(brands);
    }
}

