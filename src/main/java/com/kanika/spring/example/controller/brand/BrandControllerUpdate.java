package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.entity.Brand;
import com.kanika.spring.example.service.brand.BrandServiceUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandControllerUpdate{

    private final BrandServiceUpdate brandServiceUpdate;

    //@Autowired
    public BrandControllerUpdate(BrandServiceUpdate brandServiceUpdate) {
        this.brandServiceUpdate = brandServiceUpdate;
    }

    @PutMapping
    Brand updateBrand(@RequestBody Brand brand) {
        return brandServiceUpdate.updateBrand(brand);
    }

    @DeleteMapping("/{id}")
    String deleteBrand(@PathVariable int id) {
        return brandServiceUpdate.deleteBrand(id);
    }
}
