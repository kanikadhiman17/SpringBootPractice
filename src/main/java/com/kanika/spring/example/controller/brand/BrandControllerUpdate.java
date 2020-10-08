package com.kanika.spring.example.controller.brand;

import com.kanika.spring.example.domain.persistence.entity.Brand;
import com.kanika.spring.example.domain.persistence.entity.BrandDTO;
import com.kanika.spring.example.domain.service.brand.BrandServiceUpdate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandControllerUpdate{

    private final BrandServiceUpdate brandServiceUpdate;

    //@Autowired
    public BrandControllerUpdate(BrandServiceUpdate brandServiceUpdate) {
        this.brandServiceUpdate = brandServiceUpdate;
    }

    @PutMapping("/{id}")
    Brand updateBrand(@RequestBody BrandDTO brandDTO, @PathVariable int id) {
        return brandServiceUpdate.updateBrand(brandDTO, id);
    }

    @DeleteMapping("/{id}")
    String deleteBrand(@PathVariable int id) {
        return brandServiceUpdate.deleteBrand(id);
    }
}
